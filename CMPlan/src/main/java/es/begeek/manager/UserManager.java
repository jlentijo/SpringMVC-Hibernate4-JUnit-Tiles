package es.begeek.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;

import es.begeek.dao.UserDao;
import es.begeek.entity.User;
import es.begeek.utils.Converter;
import es.begeek.view.UserView;

@Component
public class UserManager {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private UserDao userDao;

	@Cacheable(cacheName = "user")
	public List<UserView> listUsers() {
		if (log.isDebugEnabled()) {
			log.debug("-> listUsers()");
		}
		List<User> listUsers = userDao.listUsers();
		List<UserView> listUsersView = new ArrayList<UserView>();
		for(User user : listUsers){
			listUsersView.add((UserView)Converter.convertEntityToDTO(user,new UserView()));
		}
		if (log.isDebugEnabled()) {
			log.debug("<- listUsers( List<UserView> listUsersView:="+ listUsersView +" )");
		}
		return listUsersView;
	}
	//@Cacheable(cacheName = "user")
	public UserView loadUser( Long idUser ) {
		if (log.isDebugEnabled()) {
			log.debug("-> loadUser( Long idUser:="+ idUser +" )");
		}
		UserView user = (UserView)Converter.convertEntityToDTO(userDao.loadUser(idUser),new UserView());
		if (log.isDebugEnabled()) {
			log.debug("<- loadUser( UserView user:="+ user +" )");
		}
		return user;
	}
	@TriggersRemove(cacheName="user", removeAll=true)
	public void deleteUser( UserView user ) {
		if (log.isDebugEnabled()) {
			log.debug("-> deleteUser( UserView user:="+ user +" )");
		}
		this.userDao.deleteUser((User)Converter.convertDTOToEntity(user,new User()));
		if (log.isDebugEnabled()) {
			log.debug("<- deleteUser( void )");
		}
	}
	@TriggersRemove(cacheName="user", removeAll=true)
	public void saveUser( UserView user ) {
		if (log.isDebugEnabled()) {
			log.debug("-> saveUser( UserView user:="+ user +" )");
		}
		this.userDao.saveUser((User)Converter.convertDTOToEntity(user,new User()));
		if (log.isDebugEnabled()) {
			log.debug("<- saveUser( void )");
		}
	}
}

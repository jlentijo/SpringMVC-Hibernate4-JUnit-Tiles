package es.begeek.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.begeek.annotation.Timer;
import es.begeek.manager.UserManager;
import es.begeek.view.UserView;

@Service
public class UserService {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private UserManager userMgr;
	
	@Timer @Transactional(readOnly=true)
	public List<UserView> filterList(){
		if (log.isDebugEnabled()) {
			log.debug("-> filterList()");
		}
		List<UserView> listUsers = userMgr.listUsers();
		if (log.isDebugEnabled()) {
			log.debug("<- filterList( List<UserView> listUsers:="+ listUsers +" )");
		}
		return listUsers;
	}
	@Timer @Transactional(readOnly=true)
	public UserView loadUser( Long idUser ){
		if (log.isDebugEnabled()) {
			log.debug("-> loadUser( Long idUser:="+ idUser +" )");
		}
		UserView user = userMgr.loadUser(idUser);
		if (log.isDebugEnabled()) {
			log.debug("<- loadUser( UserView user:="+ user +" )");
		}
		return user;
	}
	@Timer @Transactional
	public void save( UserView user ){
		if (log.isDebugEnabled()) {
			log.debug("-> save( UserView user:="+ user +" )");
		}
		userMgr.saveUser(user);
		if (log.isDebugEnabled()) {
			log.debug("<- save( void )");
		}
	}
	@Timer @Transactional
	public void delete( UserView user ){
		if (log.isDebugEnabled()) {
			log.debug("-> delete( UserView user:="+ user +" )");
		}
		userMgr.deleteUser(user);
		if (log.isDebugEnabled()) {
			log.debug("<- delete( void )");
		}
	}
	
}
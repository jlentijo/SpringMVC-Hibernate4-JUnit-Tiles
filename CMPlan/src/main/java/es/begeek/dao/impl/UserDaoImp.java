package es.begeek.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.begeek.dao.UserDao;
import es.begeek.entity.User;

@Component
public class UserDaoImp implements UserDao{

	private final Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	public List<User> listUsers() {
		if (log.isDebugEnabled()) {
			log.debug("-> listUsers()");
		}
		List<User> listUsers = sessionFactory.getCurrentSession().createQuery("FROM User").list();
		if (log.isDebugEnabled()) {
			log.debug("<- listUsers( List<User> listUsers:="+ listUsers +" )");
		}
		return listUsers;
	}
	public User loadUser( Long idUser ) {
		if (log.isDebugEnabled()) {
			log.debug("-> loadUser( Long idUser:="+ idUser +" )");
		}
		User user = (User) sessionFactory.getCurrentSession().load(User.class, idUser);
		if (log.isDebugEnabled()) {
			log.debug("<- listUsers( User user:="+ user +" )");
		}
		return user;
	}
	public void deleteUser( User user ) {
		if (log.isDebugEnabled()) {
			log.debug("-> deleteUser( User user:="+ user +" )");
		}
		this.sessionFactory.getCurrentSession().delete(user);
		if (log.isDebugEnabled()) {
			log.debug("<- deleteUser( void )");
		}
	}
	public void saveUser( User user ) {
		if (log.isDebugEnabled()) {
			log.debug("-> saveUser( User user:="+ user +" )");
		}
		if(user.getIdUser() != null){
			user.onPreUpdate();
			this.sessionFactory.getCurrentSession().merge(user);
		}else{
			user.onPreCreate();
			this.sessionFactory.getCurrentSession().save(user);
		}
		if (log.isDebugEnabled()) {
			log.debug("<- saveUser( void )");
		}
	}

}

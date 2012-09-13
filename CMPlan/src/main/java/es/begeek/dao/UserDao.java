package es.begeek.dao;

import java.util.List;

import es.begeek.entity.User;

public interface UserDao {
	
	public List<User> listUsers();
	public void deleteUser( User user );
	public void saveUser( User user );
	public User loadUser();
	
}

package es.begeek.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.begeek.TestBase;
import es.begeek.view.UserView;

@Component
public class TestUserService extends TestBase {

	@Autowired
	private UserService userSrc;
	private final static int SIZE_USERS = 20;
	private final static String TABLE_NAME = "user";
	
	@Before
	public void beforeTest(){
		for(int i=0; i < SIZE_USERS; i++){
			userSrc.save(new UserView(null, "jlentijo"+i, "Juan Manuel", "Lentijo Mondéjar"));
		}
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void testSaveExistUsername() {
		userSrc.save(new UserView(null, "jlentijo", "Juan Manuel", "Lentijo Mondéjar"));
		userSrc.save(new UserView(null, "jlentijo", "Juan Manuel", "Lentijo Mondéjar"));
	}
	
	@Test
	public void testGetUsersWithoutCache() {
		List<UserView> listUsers = userSrc.filterList();
		Assert.assertEquals("JDBC query must show the same number of users.",listUsers.size(), super.countRowsInTable(TABLE_NAME));
	}
	
	@Test
	public void testGetUsersWithCache() {
		List<UserView> listUsers = userSrc.filterList();
		Assert.assertEquals("JDBC query must show the same number of users.",listUsers.size(), super.countRowsInTable(TABLE_NAME));
	}
	
	@Test
	public void testDelete() {
		userSrc.delete(new UserView(1L));
	}
	
}

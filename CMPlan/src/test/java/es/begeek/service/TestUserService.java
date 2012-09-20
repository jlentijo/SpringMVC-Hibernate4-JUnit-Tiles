package es.begeek.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.begeek.TestBase;
import es.begeek.view.UserView;

@Component
public class TestUserService extends TestBase {

	@Autowired
	private UserService userSrc;
	private final Logger log = Logger.getLogger(this.getClass());
	private final static String TABLE_NAME = "user";
	
//	@Before
//	public void beforeTest(){
//		for(int e=0; e<super.cacheManager.getCacheNames().length; e++){
//			String cacheName = super.cacheManager.getCacheNames()[e];
//			System.out.println("-> CacheName: "+cacheName);
//			for(int i=0; i<super.cacheManager.getCache(cacheName).getKeys().size(); i++){
//				System.out.println("\t-> KeyNames["+i+"]: "+super.cacheManager.getCache(cacheName).getKeys().get(i).toString());
//			}
//		}
//		this.listUsers = userSrc.filterList();
//	}
	
	@Test(expected=ConstraintViolationException.class)
	public void testSaveExistUsername() {
		if (log.isDebugEnabled()) {
			log.debug("-> testSaveExistUsername()");
		}
		userSrc.save(new UserView(null, "jlentijo", "Juan Manuel", "Lentijo Mondéjar"));
	}
	
	@Test
	public void testGetListUsersWithoutCache() {
		if (log.isDebugEnabled()) {
			log.debug("-> testGetListUsersWithoutCache()");
		}
		List<UserView> listUsers = userSrc.filterList();
		Assert.assertEquals("JDBC query must show the same number of users.",listUsers.size(), super.countRowsInTable(TABLE_NAME));
	}
	
	@Test
	public void testGetListUsersWithCache() {
		if (log.isDebugEnabled()) {
			log.debug("-> testGetListUsersWithCache()");
		}
		List<UserView> listUsers = userSrc.filterList();
		Assert.assertEquals("JDBC query must show the same number of users.",listUsers.size(), super.countRowsInTable(TABLE_NAME));
	}
	
	@Test
	public void testDeleteUser() {
		if (log.isDebugEnabled()) {
			log.debug("-> testDeleteUser()");
		}
		userSrc.delete(new UserView(1L));
	}
	
//	@After
//	public void afterTest(){
//		this.listUsers = null;
//	}
	
}

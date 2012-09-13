/**
 * 
 */
package es.begeek.Controller;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import es.begeek.TestBase;
import es.begeek.controller.UserAction;

@Component
public class TestUserAction extends TestBase{

	@Autowired
	private UserAction userAction;
	
	/**
	 * Test method for {@link es.begeek.controller.UserAction#init()}.
	 */
	@Test
	public void testInit() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link es.begeek.controller.UserAction#save()}.
	 */
	@Test
	public void testSave() {
		ModelAndView result = userAction.save();
		Assert.assertEquals("user", result.getViewName());
	}

	/**
	 * Test method for {@link es.begeek.controller.UserAction#delete(java.lang.Long)}.
	 */
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link es.begeek.controller.UserAction#loadUser(java.lang.String)}.
	 */
	@Test
	public void testLoadUser() {
		fail("Not yet implemented");
	}

}

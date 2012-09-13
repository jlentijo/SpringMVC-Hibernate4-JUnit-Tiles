package es.begeek.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import es.begeek.annotation.Timer;
import es.begeek.service.UserService;
import es.begeek.view.UserView;

@Controller 
@Scope("request")
@RequestMapping("/user")
public class UserAction {
	
	private final Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private UserService userSvc;
	
	@RequestMapping("/listUser.htm")
	public ModelAndView init(){
		if (log.isDebugEnabled()) {
			log.debug("-> init()");
		}
		ModelAndView model = new ModelAndView("user");
		model.addObject("listUsers",userSvc.filterList());
		if (log.isDebugEnabled()) {
			log.debug("<- init( List<UserView> listUser:="+ model.getModel().get("listUsers") +" )");
		}
		return model;
	}
	@Timer
	@RequestMapping(value="/saveUser.htm")
	public ModelAndView save(){
		if (log.isDebugEnabled()) {
			log.debug("-> save()");
		}
		this.userSvc.save(new UserView(null,"jLentijo","Juan Manuel","Lentijo Mondéjar"));
		ModelAndView model = new ModelAndView("user");
		model.addObject("listUsers",userSvc.filterList());
		if (log.isDebugEnabled()) {
			log.debug("<- save( List<UserView> listUser:="+ model.getModel().get("listUsers") +" )");
		}
		return model;
	}
	@RequestMapping(value="/deleteUser/{idUser}.htm")
	public ModelAndView delete( @PathVariable Long idUser ){
		if (log.isDebugEnabled()) {
			log.debug("-> delete( Long idUser:="+ idUser +" )");
		}
		this.userSvc.delete(new UserView(idUser));
		ModelAndView model = new ModelAndView("user");
		model.addObject("listUsers",userSvc.filterList());
		if (log.isDebugEnabled()) {
			log.debug("<- delete( List<UserView> listUser:="+ model.getModel().get("listUsers") +" )");
		}
		return model;
	}
	@RequestMapping(value="/{username}.htm", method = RequestMethod.GET)
	public @ResponseBody UserView loadUser( @PathVariable String username ){
		if (log.isDebugEnabled()) {
			log.debug("-> jsonMethod( String username:="+ username +" )");
		}
		UserView user = new UserView(1L,username,"Juan Manuel","Lentijo Mondéjar");
		if (log.isDebugEnabled()) {
			log.debug("<- jsonMethod( UserView user:="+ user +" )");
		}
		return user;
	}
	
}
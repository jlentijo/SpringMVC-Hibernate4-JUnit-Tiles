package es.begeek.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import es.begeek.service.UserService;
import es.begeek.view.UserView;

@Controller 
@Scope("request")
@RequestMapping("/user")
public class UserAction {
	
	private final Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private UserService userSvc;
	
	@RequestMapping("/initUser.htm")
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
//	@RequestMapping(value="/listUser.htm", method = RequestMethod.GET)
//	public @ResponseBody List<UserView> list(){
//		if (log.isDebugEnabled()) {
//			log.debug("-> list()");
//		}
//		List<UserView> listUsers = userSvc.filterList();
//		if (log.isDebugEnabled()) {
//			log.debug("<- list( List<UserView> listUser:="+ listUsers +" )");
//		}
//		return listUsers;
//	}
	@RequestMapping(value="/loadUser/{idUser}.htm", method = RequestMethod.GET)
	public UserView loadUser( @PathVariable Long idUser ){
		if (log.isDebugEnabled()) {
			log.debug("-> loadUser( Long idUser:="+ idUser +" )");
		}
		UserView user = userSvc.loadUser(idUser);
		if (log.isDebugEnabled()) {
			log.debug("<- loadUser( UserView user:="+ user +" )");
		}
		return user;
	}
	@RequestMapping(value="/saveUser.htm", method = RequestMethod.POST)
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
	@RequestMapping(value="/deleteUser/{idUser}.htm", method = RequestMethod.GET)
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
}
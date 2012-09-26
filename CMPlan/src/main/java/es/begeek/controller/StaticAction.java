package es.begeek.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class StaticAction {
	private final Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping("index.htm")
	public ModelAndView home(){
		if (log.isDebugEnabled()) {
			log.debug("-> home()");
		}
		ModelAndView model = new ModelAndView("home");
		if (log.isDebugEnabled()) {
			log.debug("<- home( ModelAndView model:="+ model +" )");
		}
		return model;
	}
}

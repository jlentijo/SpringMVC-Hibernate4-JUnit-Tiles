package es.begeek.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error")
public class ErrorAction {
	private final Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping("404.htm")
	public ModelAndView error404(){
		if (log.isDebugEnabled()) {
			log.debug("-> error404()");
		}
		ModelAndView model = new ModelAndView("error");
		model.addObject("message_error", "La pagina solicitada no existe!");
		if (log.isDebugEnabled()) {
			log.debug("<- error404( ModelAndView model:="+ model +" )");
		}
		return model;
	}
	@RequestMapping("403.htm")
	public ModelAndView error403(){
		if (log.isDebugEnabled()) {
			log.debug("-> error403()");
		}
		ModelAndView model = new ModelAndView("error");
		model.addObject("message_error", "No tiene permisos para ver la página solicitada!");
		if (log.isDebugEnabled()) {
			log.debug("<- error403( ModelAndView model:="+ model +" )");
		}
		return model;
	}
}

package es.begeek.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import es.begeek.view.MonitoringView;

@Controller
@Scope("request")
@RequestMapping("/monitoring")
public class MonitoringAction {
	private final Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping("/monitoring.htm")
	public ModelAndView init(){
		if (log.isDebugEnabled()) {
			log.debug("-> init()");
		}
		ModelAndView model = new ModelAndView("monitoring");
		MonitoringView monitoring = new MonitoringView("DESCRIPCIÓN",new Date());
		model.addObject("monitoring",monitoring);
		if (log.isDebugEnabled()) {
			log.debug("<- init( MonitoringView monitoring:="+ monitoring +" )");
		}
		return model;
	}
	
	@RequestMapping(value="/{user}.htm", method = RequestMethod.GET)
	public @ResponseBody MonitoringView jsonMethod( @PathVariable String user ){
		if (log.isDebugEnabled()) {
			log.debug("-> jsonMethod( String user:="+ user +" )");
		}
		MonitoringView monitoring = new MonitoringView(user,new Date());
		if (log.isDebugEnabled()) {
			log.debug("<- jsonMethod( MonitoringView monitoring:="+ monitoring +" )");
		}
		return monitoring;
	}
}

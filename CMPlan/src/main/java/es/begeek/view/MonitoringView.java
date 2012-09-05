package es.begeek.view;

import java.util.Date;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import es.begeek.utils.JsonDateSerializer;

public class MonitoringView {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	private String description;
	private Date date;
	
	/*
	 * CONSTRUCTORS
	 */
	public MonitoringView(){}
	public MonitoringView(String description, Date date){
		if (log.isDebugEnabled()) {
			log.debug("-> MonitoringView( String description:="+ description +", String date:="+ date +" )");
		}
		this.description = description;
		this.date = date;
		if (log.isDebugEnabled()) {
			log.debug("<- MonitoringView( void )");
		}
	}
	/*
	 * GETTERS
	 */
	public String getDescription() {
		return description;
	}
	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getDate() {
		return date;
	}
	/*
	 * SETTERS
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}

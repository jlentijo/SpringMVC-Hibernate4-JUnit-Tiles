package es.begeek.entity.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.log4j.Logger;

@MappedSuperclass
public class CommonParams {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	private Date insert_date;
	private Date last_update_date;
	
	/*
	 * LISTENERS
	 */
	@PrePersist
	public void onPreCreate() {
		if (log.isDebugEnabled()) {
			log.debug("<- onPreCreate()");
		}
		this.insert_date = new Date();
		this.last_update_date = new Date();
		if (log.isDebugEnabled()) {
			log.debug("<- onPreCreate( void )");
		}
	}
	@PreUpdate
	public void onPreUpdate() {
		if (log.isDebugEnabled()) {
			log.debug("<- onPreUpdate()");
		}
		this.last_update_date = new Date();
		if (log.isDebugEnabled()) {
			log.debug("<- onPreUpdate( void )");
		}
	}
	/*
	 * GETTERS
	 */
	@Column(name = "_INSER_DATE", nullable=false)
	public Date getInsert_date() {
		return insert_date;
	}
	@Column(name = "_LAST_UPDATE_DATE", nullable=false)
	public Date getLast_update_date() {
		return last_update_date;
	}
	/*
	 * SETTERS
	 */
	public void setInsert_date(Date insert_date) {
		this.insert_date = insert_date;
	}
	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}
}

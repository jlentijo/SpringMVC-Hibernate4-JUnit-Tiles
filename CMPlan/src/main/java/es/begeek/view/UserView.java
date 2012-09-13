package es.begeek.view;

import org.apache.log4j.Logger;

public class UserView {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	private Long idUser;
	private String username;
	private String name;
	private String surnames;
	private String insert_date;
	private String last_update_date;
	
	/*
	 * CONSTRUCTORS	
	 */
	public UserView(Long idUser){
		if(log.isDebugEnabled()){
			log.debug("-> new UserView( Long idUser:="+ idUser +" )");
		}
		this.idUser = idUser;
		if(log.isDebugEnabled()){
			log.debug("<- new UserView( void )");
		}
	}
	public UserView(Long idUser, String username, String name, String surnames){
		if(log.isDebugEnabled()){
			log.debug("-> new UserView( Long idUser:="+ idUser +", String username:="+ username +", String name:="+ name +", String surnames:="+ surnames +" )");
		}
		this.idUser = idUser;
		this.username = username;
		this.name = name;
		this.surnames = surnames;
		if(log.isDebugEnabled()){
			log.debug("<- new UserView( void )");
		}
	}
	/*
	 * GETTERS
	 */
	public Long getIdUser() {
		return idUser;
	}
	public String getUsername() {
		return username;
	}
	public String getName() {
		return name;
	}
	public String getSurnames() {
		return surnames;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public String getLast_update_date() {
		return last_update_date;
	}
	/*
	 * SETTERS
	 */
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	public void setLast_update_date(String last_update_date) {
		this.last_update_date = last_update_date;
	}
}
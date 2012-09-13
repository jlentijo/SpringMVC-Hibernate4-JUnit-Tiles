package es.begeek.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import es.begeek.entity.common.CommonParams;

@Entity
@Table(name = "user")
@EntityListeners(CommonParams.class)
public class User extends CommonParams implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long idUser;
	private String username;
	private String name;
	private String surnames;

	/*
	 * GETTERS
	 */
	@Id
	@GeneratedValue
	@Column(name = "idUser")
	public Long getIdUser() {
		return idUser;
	}
	@Column(name = "username", unique=true)
	public String getUsername() {
		return username;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}
	@Column(name = "surnames")
	public String getSurnames() {
		return surnames;
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
}

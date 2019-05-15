package web.clinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import web.clinic.validator.validator.UsernameUnique;


@Entity
@Table(name="user")
public class User extends PersonalDetails {

	// @UsernameUnique is checking if username is already used;
	@Id
	@Column(name="username")
	@UsernameUnique
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="mail")
	private String mail;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	
}

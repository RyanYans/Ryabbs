package com.rya.bbs.userbean;

import java.util.Date;


public class UserBean {
	private String username;
	private String password;
	private Date birthday;
	private String email;
	
	public UserBean() {
	}
	
	public UserBean(String username, String password, Date birthday,
			String email) {
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.email = email;
	}
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserBean [username=" + username + ", password=" + password
				+ ", birthday=" + birthday + ", email=" + email + "]";
	}
	
	
}

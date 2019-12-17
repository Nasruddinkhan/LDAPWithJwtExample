package com.mypractice.jwttoken.bean;

/**
 * NK5050747 LoginBean.java Dec 12, 2019 9:10:41 PM
 */
public class LoginBean {
	private String username;
	private String password;

	public LoginBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

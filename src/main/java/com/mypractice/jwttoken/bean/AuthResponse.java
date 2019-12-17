package com.mypractice.jwttoken.bean;
/**
 * NK5050747
 * AuthResponse.java
 * Dec 12, 2019 9:26:50 PM
 */
public class AuthResponse {
	private final String jwt;

	public AuthResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

}

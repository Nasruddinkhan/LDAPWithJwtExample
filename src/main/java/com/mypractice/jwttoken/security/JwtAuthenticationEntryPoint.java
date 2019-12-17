package com.mypractice.jwttoken.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * NK5050747
 * JwtAuthenticationEntryPoint.java
 * Dec 13, 2019 4:26:54 PM
 */
@Component
public class JwtAuthenticationEntryPoint  implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UNAUTHORIZED");

	}

}

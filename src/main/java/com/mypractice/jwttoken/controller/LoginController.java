package com.mypractice.jwttoken.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.jwttoken.bean.LoginBean;
import com.mypractice.jwttoken.security.JwtUtil;

/**
 * NK5050747
 * LoginController.java
 * Dec 12, 2019 9:12:52 PM
 */
@RestController
public class LoginController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private UserDetailsService userServiceDtl;
	
	@Autowired
	private JwtUtil JwtUtil;
	@PostMapping("/login")
	public ResponseEntity<?> validate(@RequestBody LoginBean loginBean) {
		
		 try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(loginBean.getUsername(), loginBean.getPassword()));
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Bad Credential ");
		}
		final UserDetails userDetails = userServiceDtl.loadUserByUsername(loginBean.getUsername());
		String jwt = JwtUtil.genrateToken(userDetails);
		return ResponseEntity.ok(jwt);
		
	}
}

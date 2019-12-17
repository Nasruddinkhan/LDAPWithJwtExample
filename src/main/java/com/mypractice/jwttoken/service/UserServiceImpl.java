package com.mypractice.jwttoken.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * NK5050747
 * UserDetailsService.java
 * Dec 13, 2019 4:09:43 PM
 */

  @Service
  public class UserServiceImpl implements  UserDetailsService {
	  @Override 
	  public UserDetails loadUserByUsername(String username) throws
	  UsernameNotFoundException {
		  // TODO Auto-generated method stub 
		  System.out.println("UserServiceImpl.loadUserByUsername()"+username);
		  return new  User("USER", "USER", new ArrayList<>()); 
	  }

  }
 
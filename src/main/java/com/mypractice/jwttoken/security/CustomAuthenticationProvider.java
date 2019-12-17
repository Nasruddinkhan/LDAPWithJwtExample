package com.mypractice.jwttoken.security;
/**
 * NK5050747
 * CustomAuthenticationProvider.java
 * Dec 13, 2019 3:38:28 PM
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public final class CustomAuthenticationProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		System.out.println("username "+username);
		System.out.println("password "+password);
		if(AdManager.authorizedUser(username, password)) {
			List<GrantedAuthority> grantedAuths  = new ArrayList<GrantedAuthority>();
			grantedAuths.add((GrantedAuthority) new SimpleGrantedAuthority("ADMIN"));
			return new UsernamePasswordAuthenticationToken(username, password, grantedAuths);
		}else {
			throw new AuthenticationCredentialsNotFoundException("Invalid Credentials!");
		}
		// TODO Auto-generated catch block
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}

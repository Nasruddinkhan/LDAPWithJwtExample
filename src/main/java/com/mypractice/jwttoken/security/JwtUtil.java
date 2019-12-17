package com.mypractice.jwttoken.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * NK5050747
 * JwtUtil.java
 * Dec 12, 2019 8:20:00 PM
 */
@Component
public class JwtUtil {
	public String SECRET_KEY="seceret";
	public String extractUserName(String token) {
		return extractClaim(token, Claims::getSubject);

	}
	public <T> T extractClaim(String token, Function<Claims, T> claim) {
		// TODO Auto-generated method stub
		final Claims claims = extractAllClaims(token);
		return claim.apply(claims);
	}
	public Claims extractAllClaims(String token) {
		// TODO Auto-generated method stub
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
	public String genrateToken(UserDetails userDetails) {
		Map<String, Object> claim= new HashMap<>();
		return createToken(claim, userDetails.getUsername());
		
	}
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());         
	}
	private Date extractExpiration(String token) {
		// TODO Auto-generated method stub
		return extractClaim(token, Claims::getExpiration);
	}
	private String createToken(Map<String, Object> claim, String username) {
		// TODO Auto-generated method stub
		return 	Jwts.builder()
				.setClaims(claim)
				.setSubject(username)
				.setIssuedAt(new  Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000 * 60 * 60 *10))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
				.compact();
	}
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String userName = extractUserName(token);
		return ( userName.equals(userDetails.getUsername()) && isTokenExpired(token));
	}
}

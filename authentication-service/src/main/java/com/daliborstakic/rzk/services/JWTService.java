package com.daliborstakic.rzk.services;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	public static final String Secret = "13YftlGeO0/w6PDF0brOP7U6itMln9XNo5qou6Lh7xpl9MFV88OTYYfASO9LOo2O\n";

	public void validateToken(final String token) {
		System.out.println("Jovan");
		Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
	}

	public String generateToken(String username) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, username);
	}

	private String createToken(Map<String, Object> claims, String username) {
		return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() * 1000 * 60 * 30))
				.signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
	}

	private Key getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(Secret);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}

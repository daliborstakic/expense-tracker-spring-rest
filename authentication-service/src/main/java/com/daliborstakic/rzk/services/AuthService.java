package com.daliborstakic.rzk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.daliborstakic.rzk.beans.User;
import com.daliborstakic.rzk.proxies.JWTProxy;
import com.daliborstakic.rzk.proxies.UserProxy;

@Service
public class AuthService {
	@Autowired
	private UserProxy userProxy;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JWTProxy jwtProxy;

	public String saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));	
		User savedUser = userProxy.saveUser(user);

		if (savedUser == null)
			throw new RuntimeException("User already exists: " + user.getUsername());

		return "User saved";
	}

	public String generateToken(String username) {
		return jwtProxy.generateToken(username);
	}

	public void validateToken(String token) {
		jwtProxy.validateToken(token);
	}
}

package com.daliborstakic.rzk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.daliborstakic.rzk.model.User;
import com.daliborstakic.rzk.repositories.UserRepository;

@Service
public class AuthService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JWTService jwtService;

	public String saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "User saved";
	}

	public String generateToken(String username) {
		return jwtService.generateToken(username);
	}

	public void validateToken(String token) {
		jwtService.validateToken(token);
	}
}

package com.daliborstakic.rzk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daliborstakic.rzk.beans.AuthRequest;
import com.daliborstakic.rzk.model.User;
import com.daliborstakic.rzk.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthService authService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/register")
	public String register(@RequestBody User newUser) {
		return authService.saveUser(newUser);
	}

	@PostMapping("/token")
	public String getToken(@RequestBody AuthRequest authRequest) {
		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

		if (authenticate.isAuthenticated())
			return authService.generateToken(authRequest.getUsername());
		else
			throw new RuntimeException("Invalid access");
	}

	@GetMapping("/validateToken/{token}")
	public String validateToken(@PathVariable String token) {
		authService.validateToken(token);
		return "Token is validated";
	}
}

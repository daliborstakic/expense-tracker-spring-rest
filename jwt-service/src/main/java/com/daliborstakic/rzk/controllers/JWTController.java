package com.daliborstakic.rzk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daliborstakic.rzk.services.JWTService;

@RestController
@RequestMapping("/jwt")
public class JWTController {
	@Autowired
	private JWTService jwtService;

	@GetMapping("/generateToken/{username}")
	public String generateToken(@PathVariable String username) {
		return jwtService.generateToken(username);
	}

	@GetMapping("/validateToken/{token}")
	public void validateToken(@PathVariable String token) {
		jwtService.validateToken(token);
	}

	@GetMapping("/getUsername/{token}")
	public String getUsername(@PathVariable String token) {
		return jwtService.extractUsername(token);
	}
}

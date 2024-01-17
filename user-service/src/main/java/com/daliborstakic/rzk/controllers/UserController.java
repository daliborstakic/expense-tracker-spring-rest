package com.daliborstakic.rzk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daliborstakic.rzk.exceptions.UserAlreadyExistsException;
import com.daliborstakic.rzk.exceptions.UserNotFoundException;
import com.daliborstakic.rzk.model.User;
import com.daliborstakic.rzk.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user) {
		try {
			return userService.saveUser(user);
		} catch (UserAlreadyExistsException e) {
			return null;
		}
	}

	@GetMapping("/findByUsername/{username}")
	public User findByUsername(@PathVariable String username) {
		try {
			return userService.findByUsername(username);
		} catch (UserNotFoundException e) {
			return null;
		}
	}
}

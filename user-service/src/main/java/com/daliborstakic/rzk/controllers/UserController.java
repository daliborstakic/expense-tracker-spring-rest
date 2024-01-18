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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/saveUser")
	public User saveUser(@RequestBody @Valid User user) throws UserAlreadyExistsException {
		return userService.saveUser(user);
	}

	@GetMapping("/findByUsername/{username}")
	public User findByUsername(@PathVariable @Valid String username) throws UserNotFoundException {
		return userService.findByUsername(username);
	}
}

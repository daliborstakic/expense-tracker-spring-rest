package com.daliborstakic.rzk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daliborstakic.rzk.exceptions.UserAlreadyExistsException;
import com.daliborstakic.rzk.exceptions.UserNotFoundException;
import com.daliborstakic.rzk.model.User;
import com.daliborstakic.rzk.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) throws UserAlreadyExistsException {
		Optional<User> existingUser = userRepository.findByUsername(user.getUsername());

		if (existingUser.isPresent())
			throw new UserAlreadyExistsException(user.getUsername());

		return userRepository.save(user);
	}

	public User findByUsername(String username) throws UserNotFoundException {
		Optional<User> potentialUser = userRepository.findByUsername(username);

		if (potentialUser.isEmpty())
			throw new UserNotFoundException(username);

		return potentialUser.get();
	}
}

package com.daliborstakic.rzk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.daliborstakic.rzk.beans.User;
import com.daliborstakic.rzk.proxies.UserProxy;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserProxy userProxy;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userProxy.findByUsername(username);

		if (user == null)
			throw new RuntimeException("User not found with: " + username);

		return new CustomUserDetails(user);
	}
}

package com.daliborstakic.rzk.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.daliborstakic.rzk.model.User;

import jakarta.validation.Valid;

@FeignClient(name = "user-service", url = "http://localhost:9069/users")
public interface UserProxy {
	@GetMapping("/findByUsername/{username}")
	public User findByUsername(@PathVariable String username);

	@PostMapping("/saveUser")
	public User saveUser(@RequestBody @Valid User user);
}

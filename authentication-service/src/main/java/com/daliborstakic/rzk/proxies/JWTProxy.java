package com.daliborstakic.rzk.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "jwt-service", url = "http://localhost:8777/jwt")
public interface JWTProxy {
	@GetMapping("/generateToken/{username}")
	public String generateToken(@PathVariable String username);

	@GetMapping("/validateToken/{token}")
	public void validateToken(@PathVariable String token);
}

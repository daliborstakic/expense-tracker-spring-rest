package com.daliborstakic.rzk.filters;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.client.RestTemplate;

import com.daliborstakic.rzk.config.RouteValidator;
import com.google.common.net.HttpHeaders;

public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
	@Autowired
	private RouteValidator validator;

	public AuthenticationFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		return (exchange, chain) -> {
			ServerHttpRequest newRequest = null;

			if (validator.isSecured.test(exchange.getRequest())) {
				if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION))
					throw new RuntimeException("Missing authorization header!");
			}

			String authHeaders = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);

			if (authHeaders != null && authHeaders.startsWith("Bearer ")) {
				authHeaders = authHeaders.substring(7);
			}

			try {
				String url = "http://localhost:8777/jwt/validateToken/{token}";

				Map<String, Object> pathVariables = new HashMap<>(); 
				pathVariables.put("token", authHeaders);

				new RestTemplate().getForEntity(url, Void.class, pathVariables);

				url = "http://localhost:8777/jwt/getUsername/{token}";

				pathVariables = new HashMap<>();
				pathVariables.put("token", authHeaders);

				ResponseEntity<String> username = new RestTemplate().getForEntity(url, String.class, pathVariables);

				newRequest = exchange.getRequest().mutate().header("loggedUsername", username.getBody()).build();
			} catch (Exception e) {
				throw new RuntimeException("Unauthorized access");
			}

			return chain.filter(exchange.mutate().request(newRequest).build());
		};
	}

	public static class Config {

	}
}

package com.daliborstakic.rzk.filters;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
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
			if (validator.isSecured.test(exchange.getRequest())) {
				if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION))
					throw new RuntimeException("Missing authorization header!");
			}

			String authHeaders = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);

			if (authHeaders != null && authHeaders.startsWith("Bearer ")) {
				authHeaders = authHeaders.substring(7);
			}

			try {
				String url = "http://localhost:8765/auth/validateToken/{authHeaders}";

				Map<String, Object> pathVariables = new HashMap<>();
				pathVariables.put("authHeaders", authHeaders);

				System.out.println(pathVariables);

				new RestTemplate().getForEntity(url, Void.class, pathVariables);
			} catch (Exception e) {
				throw new RuntimeException("Unauthorized access");
			}

			return chain.filter(exchange);
		};
	}

	public static class Config {

	}
}

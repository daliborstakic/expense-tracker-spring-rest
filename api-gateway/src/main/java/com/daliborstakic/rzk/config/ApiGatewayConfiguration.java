package com.daliborstakic.rzk.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.daliborstakic.rzk.filters.AuthenticationFilter;
import com.daliborstakic.rzk.filters.AuthenticationFilter.Config;

@Configuration
public class ApiGatewayConfiguration {
	@Bean
	public AuthenticationFilter authenticationFilter() {
		return new AuthenticationFilter();
	}

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes().route(p -> p.path("/auth/**").uri("lb://authentication-service"))
				.route(p -> p.path("/currencies/**").filters(f -> f.filter(authenticationFilter().apply((Config) null)))
						.uri("lb://currency-service"))
				.route(p -> p.path("/expenses/**").filters(f -> f.filter(authenticationFilter().apply((Config) null)))
						.uri("lb://expense-service"))
				.build();
	}

}

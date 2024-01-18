package com.daliborstakic.rzk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EntityScan("com.daliborstakic.rzk.model")
@EnableFeignClients
@SpringBootApplication
public class ExpenseServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExpenseServiceApplication.class, args);
	}
}

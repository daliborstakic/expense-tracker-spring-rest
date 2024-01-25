package com.daliborstakic.rzk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExpenseStatsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseStatsServiceApplication.class, args);
	}

}

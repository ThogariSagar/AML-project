package com.tejait.batch8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.tejait.batch8")
@EnableAutoConfiguration
@EnableFeignClients
public class Batch8Application {

	public static void main(String[] args) {
		SpringApplication.run(Batch8Application.class, args);
	}

}

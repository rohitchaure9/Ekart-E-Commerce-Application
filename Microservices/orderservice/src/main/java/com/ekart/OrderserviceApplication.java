package com.ekart;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class OrderserviceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(OrderserviceApplication.class, args);
		SpringApplication app = new SpringApplication(OrderserviceApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8001"));
		app.run(args);
	}

}

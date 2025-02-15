package com.ekart;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EkartserverApplication {
	public static void main(String[] args) {
		//SpringApplication.run(EkartserverApplication.class, args);
		SpringApplication app = new SpringApplication(EkartserverApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8761"));
		app.run(args);
	}

}

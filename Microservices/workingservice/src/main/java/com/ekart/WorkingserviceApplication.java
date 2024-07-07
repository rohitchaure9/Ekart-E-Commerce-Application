package com.ekart;



import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class WorkingserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkingserviceApplication.class, args);
//		SpringApplication app = new SpringApplication(WorkingserviceApplication.class);
//		app.setDefaultProperties(Collection.singletonMap("server.port", "8007"));
//		app.run(args);
	}

}

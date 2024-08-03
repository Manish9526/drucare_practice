package com.hueged.hashedin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDiscoveryServiceV1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDiscoveryServiceV1Application.class, args);
	}

}

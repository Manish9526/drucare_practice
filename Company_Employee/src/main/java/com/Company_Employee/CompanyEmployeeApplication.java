package com.Company_Employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@Configuration
@PropertySource({ "classpath:application.properties" })
public class CompanyEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyEmployeeApplication.class, args);
	}

}

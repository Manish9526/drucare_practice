package com.hueged.hashedin.Food.Service.Config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FoodSwaggerConfig {
	@Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("food-service")
                .packagesToScan("com.hueged.hashedin.Food.Service.Controller")
                .build();
    }
}


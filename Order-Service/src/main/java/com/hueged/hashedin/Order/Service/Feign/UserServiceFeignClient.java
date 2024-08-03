package com.hueged.hashedin.Order.Service.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hueged.hashedin.Food.Service.Entity.ResponseMapper;

@FeignClient(name = "USER-SERVICE")
public interface UserServiceFeignClient {

	@GetMapping("/users/{userId}")
	public ResponseMapper getSingleUser(@PathVariable String userId);
	
	@GetMapping("/users/{mailId}")
	public UserDto findByEmail(@PathVariable String mailId);
}

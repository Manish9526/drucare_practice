package com.hueged.hashedin.Order.Service.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hueged.hashedin.Food.Service.Entity.ResponseMapper;

@FeignClient(name = "FOOD-SERVICE")
public interface FoodServiceClient {

	@GetMapping("foodService/food/fooditem/{foodId}")
	public ResponseMapper getFoodById(@PathVariable String foodId);
	
	@GetMapping(path = "foodService/category/categoryId/{categoryId}")
	public ResponseMapper findByCategoryId(@PathVariable Long categoryId);
	
	@GetMapping(path = "foodService/food/restaurant/resto/{restaurantId}")
	public ResponseMapper getRestaurantById(@PathVariable String restaurantId);
	
	@GetMapping(path = "foodService/food/restaurant/rest/{restaurantId}")
	public ResponseMapper findByRestaurantId(@PathVariable Long restaurantId);

}

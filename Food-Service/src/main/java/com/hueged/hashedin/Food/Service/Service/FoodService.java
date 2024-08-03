package com.hueged.hashedin.Food.Service.Service;

import com.hueged.hashedin.Food.Service.Model.FoodItemsDto;

public interface FoodService {

	FoodItemsDto addNewFood(FoodItemsDto addFoodItemsRequest);

	FoodItemsDto findByPublicFoodId(String foodId);

}

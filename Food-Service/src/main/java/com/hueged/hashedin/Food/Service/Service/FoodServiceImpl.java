package com.hueged.hashedin.Food.Service.Service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hueged.hashedin.Food.Service.Entity.Category;
import com.hueged.hashedin.Food.Service.Entity.FoodItems;
import com.hueged.hashedin.Food.Service.Entity.Restaurant;
import com.hueged.hashedin.Food.Service.Exceptions.NoFoodFoundByIdException;
import com.hueged.hashedin.Food.Service.Model.CategoryDto;
import com.hueged.hashedin.Food.Service.Model.FoodItemsDto;
import com.hueged.hashedin.Food.Service.Model.RestaurantDto;
import com.hueged.hashedin.Food.Service.Repository.FoodItemsRepository;

import jakarta.transaction.Transactional;

@Service
public class FoodServiceImpl implements FoodService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	FoodItemsRepository foodItemsRepository;

	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	CategoryService categoryService;
	
	@Override
	@Transactional
	public FoodItemsDto addNewFood(FoodItemsDto addFoodItemsRequest) {

		ModelMapper modelMapper = new ModelMapper();
		FoodItems foodItems = modelMapper.map(addFoodItemsRequest, FoodItems.class);
		
		foodItems.setStatus("FOOD_ACTIVE");
		
		RestaurantDto restaurant = restaurantService.findByRestaurantId(addFoodItemsRequest.getRestaurantId());
		foodItems.setRestaurantId(modelMapper.map(restaurant, Restaurant.class));
		
		
		CategoryDto category = categoryService.findByCategoryId(addFoodItemsRequest.getCategoryId());
		foodItems.setCategoryId(modelMapper.map(category, Category.class));
		
		foodItems.setPublicFoodId(UUID.randomUUID().toString());
		foodItems=foodItemsRepository.save(foodItems);
		
	
		return modelMapper.map(foodItems, FoodItemsDto.class);
	}

	@Override
	public FoodItemsDto findByPublicFoodId(String foodId) {
		FoodItems foodItems = foodItemsRepository.findByPublicFoodId(foodId);
		if (foodItems == null) {
			throw new NoFoodFoundByIdException("No Foot Item Found!");
		}
		ModelMapper modelMapper = new ModelMapper();
		FoodItemsDto FoodDto = modelMapper.map(foodItems, FoodItemsDto.class);
		logger.info("Check the data " +FoodDto.getFoodName());
		return FoodDto;
	}

}

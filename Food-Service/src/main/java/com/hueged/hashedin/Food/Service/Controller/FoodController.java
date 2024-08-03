package com.hueged.hashedin.Food.Service.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hueged.hashedin.Food.Service.Entity.ResponseMapper;
import com.hueged.hashedin.Food.Service.Model.FoodItemsDto;
import com.hueged.hashedin.Food.Service.Service.FoodService;
import com.hueged.hashedin.Food.Service.Utills.FoodServiceUtills;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/food/fooditem")
@Tag(name = "Food Management", description = "Handle operations related to Food ")
public class FoodController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Autowired
	FoodService foodService;
	
	@Autowired
	FoodServiceUtills foodServiceUtills;

	@PostMapping(path = "/addfooditem")
	@Operation(summary = "Create a Food ")
	@ApiResponse(responseCode = "200", description = " Data Inserted Successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMapper.class)))
	public ResponseEntity<ResponseMapper> addFoodItems(@RequestBody FoodItemsDto addFoodItemsRequest){
		return foodServiceUtills.responseEntityForInsertSuccess(foodService.addNewFood(addFoodItemsRequest));
	
	}
	
	@GetMapping(path = "/{foodId}")
	@Operation(summary = "Get a Food by ID")
	public ResponseEntity<ResponseMapper> getFoodById(@PathVariable String foodId){
		logger.info("Print the food is "+ foodId);
		return foodServiceUtills.responseEntityForFetchSuccess(foodService.findByPublicFoodId(foodId));
	}
	
	
	
}

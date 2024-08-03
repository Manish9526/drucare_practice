package com.hueged.hashedin.Food.Service.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hueged.hashedin.Food.Service.Entity.ResponseMapper;
import com.hueged.hashedin.Food.Service.Model.RestaurantDto;
import com.hueged.hashedin.Food.Service.Service.RestaurantService;
import com.hueged.hashedin.Food.Service.Utills.FoodServiceUtills;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/food/restaurant")
@Tag(name = "Restaurant Management", description = "Handle operations related to Restaurant")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	FoodServiceUtills foodServiceUtills;
	
	@PostMapping(path = "/addrestaurant")

	@Operation(summary = "Create a Food Category")
	@ApiResponse(responseCode = "200", description = " Data Inserted Successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMapper.class)))
	public ResponseEntity<ResponseMapper> createRestaurant(@RequestBody RestaurantDto addRestaurantRequest) {

		return foodServiceUtills
				.responseEntityForInsertSuccess(restaurantService.addNewRestaurant(addRestaurantRequest));
	}
	
	
	@GetMapping(path = "/resto/{restaurantId}")
	@Operation(summary = "Get a Restaurant by ID")
	public ResponseEntity<ResponseMapper> getRestaurantById(@PathVariable String restaurantId){

		return foodServiceUtills.responseEntityForFetchSuccess(restaurantService.findByPublicRestoId(restaurantId));
		
	}
	
	@GetMapping(path = "/rest/{restaurantId}")
	@Operation(summary = "Get a Restaurant by ID")
	public ResponseEntity<ResponseMapper> findByRestaurantId(@PathVariable Long restaurantId){

		return foodServiceUtills.responseEntityForFetchSuccess(restaurantService.findByRestaurantId(restaurantId));
		
	}
	
	

}

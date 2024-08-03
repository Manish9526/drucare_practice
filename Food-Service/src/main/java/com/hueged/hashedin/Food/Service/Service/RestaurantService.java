package com.hueged.hashedin.Food.Service.Service;

import com.hueged.hashedin.Food.Service.Entity.Restaurant;
import com.hueged.hashedin.Food.Service.Model.RestaurantDto;

public interface RestaurantService {

	RestaurantDto findByRestaurantId(Long restaurantId);

	Restaurant addNewRestaurant(RestaurantDto addRestaurantRequest);

	RestaurantDto findByPublicRestoId(String restaurantId);

}

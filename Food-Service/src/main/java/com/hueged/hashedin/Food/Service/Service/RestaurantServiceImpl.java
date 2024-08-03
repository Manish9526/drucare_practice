package com.hueged.hashedin.Food.Service.Service;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hueged.hashedin.Food.Service.Entity.Restaurant;
import com.hueged.hashedin.Food.Service.Exceptions.NoRestaurantFoundException;
import com.hueged.hashedin.Food.Service.Model.RestaurantDto;
import com.hueged.hashedin.Food.Service.Repository.RestaurantRepository;

import jakarta.transaction.Transactional;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	RestaurantRepository restaurantRepository;

	

	@Override
	@Transactional
	public Restaurant addNewRestaurant(RestaurantDto restaurantDto) {
		ModelMapper modelMapper = new ModelMapper();
		Restaurant restaurant = modelMapper.map(restaurantDto, Restaurant.class);
		restaurant.setRestaurantStatus("RESTAURANT_OPEN");
		restaurant.setPublicRestoId(UUID.randomUUID().toString());
		return restaurantRepository.save(restaurant);
	}
	
	@Override
	public RestaurantDto findByRestaurantId(Long restaurantId) {
		Optional<Restaurant> restaurant =restaurantRepository.findById(restaurantId);
		if(!restaurant.isPresent()) {
			throw new NoRestaurantFoundException("No Restaurant Found");
		}
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(restaurant.get(), RestaurantDto.class) ;
	}

	@Override
	public RestaurantDto findByPublicRestoId(String restaurantId) {
		Restaurant restaurant = this.restaurantRepository.findByPublicRestoId(restaurantId);
		if (restaurant == null) {
			throw new NoRestaurantFoundException("No Restaurant Found");
		}
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(restaurant, RestaurantDto.class);
	}

}

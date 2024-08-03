package com.hueged.hashedin.Order.Service.Service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hueged.hashedin.Food.Service.Entity.ResponseMapper;
import com.hueged.hashedin.Order.Service.Entity.Cart;
import com.hueged.hashedin.Order.Service.Entity.CartDetailsDto;
import com.hueged.hashedin.Order.Service.Entity.CartDto;
import com.hueged.hashedin.Order.Service.Feign.Category;
import com.hueged.hashedin.Order.Service.Feign.FoodItemsDto;
import com.hueged.hashedin.Order.Service.Feign.FoodServiceClient;
import com.hueged.hashedin.Order.Service.Feign.Restaurant;
import com.hueged.hashedin.Order.Service.Feign.UserDto;
import com.hueged.hashedin.Order.Service.Feign.UserServiceFeignClient;
import com.hueged.hashedin.Order.Service.Repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CartRepository cartRepository;

	@Autowired
	UserServiceFeignClient userServiceFeignClient;
	
	@Autowired
	FoodServiceClient foodServiceClient;

	
	@Override
	public CartDto addToCart(Cart cartReq) {
		ModelMapper modelMapper = new ModelMapper();
		
		cartReq.setPublicCartId(UUID.randomUUID().toString());
		cartReq=cartRepository.save(cartReq);
		return  modelMapper.map(cartRepository.save(cartReq), CartDto.class);
		
	}

	@Override
	public CartDto updateCart(Cart cartReq) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(cartRepository.save(cartReq), CartDto.class);
	}

	@Override
	public CartDetailsDto getCardDetails(String cardId) {

		Cart cart =cartRepository.findByPublicCartId(cardId);
		
		CartDetailsDto CartDtoObj = new CartDetailsDto();
		// get the user details 
		ResponseMapper responseMapper=userServiceFeignClient.getSingleUser(cart.getUserId());
		ModelMapper modelMapper = new ModelMapper();
		UserDto userResponseModelFeign  = modelMapper.map(responseMapper.getData(), UserDto.class);
		CartDtoObj.setUserId(userResponseModelFeign.getId());
		CartDtoObj.setPublicUserId(userResponseModelFeign.getPublicUserId());
		CartDtoObj.setEmail(userResponseModelFeign.getEmail());
		CartDtoObj.setFirstName(userResponseModelFeign.getFirstName());
		CartDtoObj.setLastName(userResponseModelFeign.getLastName());
		CartDtoObj.setPhoneNo(userResponseModelFeign.getPhoneNo());
	

		
		ResponseMapper foodResponseMapper= foodServiceClient.getFoodById(cart.getFoodId());
		modelMapper = new ModelMapper();
		FoodItemsDto foodResponseModelFeign  = modelMapper.map(foodResponseMapper.getData(), FoodItemsDto.class);
		logger.info("Check the category id :: "+foodResponseModelFeign.getCategoryId()+"");
		CartDtoObj.setFoodId(foodResponseModelFeign.getPublicFoodId());
		CartDtoObj.setFoodName(foodResponseModelFeign.getFoodName());
		CartDtoObj.setDescription(foodResponseModelFeign.getDescription());
		CartDtoObj.setPrice(foodResponseModelFeign.getPrice());
		
		Long id =foodResponseModelFeign.getCategoryId();
		ResponseMapper categoryResponseMapper= foodServiceClient.findByCategoryId(id);
		modelMapper = new ModelMapper();
		Category categoryResponseModelFeign  = modelMapper.map(categoryResponseMapper.getData(), Category.class);
		
		
		CartDtoObj.setCategoryName(categoryResponseModelFeign.getCategoryName());
		CartDtoObj.setDescription(categoryResponseModelFeign.getDescription());
		
		
		ResponseMapper restaurantResponseMapper=foodServiceClient.findByRestaurantId(foodResponseModelFeign.getRestaurantId());
		modelMapper = new ModelMapper();
		Restaurant restaurantResponseModelFeign  = modelMapper.map(restaurantResponseMapper.getData(), Restaurant.class);
		CartDtoObj.setRestaurantName(restaurantResponseModelFeign.getRestaurantName());
		CartDtoObj.setRestaurantEmail(restaurantResponseModelFeign.getRestaurantEmail());
		CartDtoObj.setCity(restaurantResponseModelFeign.getCity());
		CartDtoObj.setPincode(restaurantResponseModelFeign.getPincode());
		
		return CartDtoObj;
	}
	

}

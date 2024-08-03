package com.hueged.hashedin.Order.Service.Entity;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CartDto {

	private Long id;
	private String userId;
	private String publicUserId;
	private String firstName;
	private String lastName;
	private String email;
	private Long PhoneNo;
	private String foodId;
	private Integer quantity;
	private String foodName;
	private String description;
	private BigDecimal price;
	private String restaurantName;
	private String city;
	 private String pincode;
	 private String restaurantEmail;
	private String categoryName;
	private String publicCartId;
	

	
	
	
	
}

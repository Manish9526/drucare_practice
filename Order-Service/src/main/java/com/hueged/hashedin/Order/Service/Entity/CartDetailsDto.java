package com.hueged.hashedin.Order.Service.Entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDetailsDto {

	private String publicCartId;
	
	private Integer userId;
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
	
}

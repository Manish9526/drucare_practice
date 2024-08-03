package com.hueged.hashedin.Order.Service.Feign;

import java.util.ArrayList;
import java.util.List;

import com.hueged.hashedin.Food.Service.Model.FoodItemsDto;

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
public class Restaurant {

	    private Long id;
	    private String restaurantName;
	    private String city;
	    private String pincode;
	    private String restaurantEmail;
	    private String restaurantStatus;
	    private String publicRestoId;

}

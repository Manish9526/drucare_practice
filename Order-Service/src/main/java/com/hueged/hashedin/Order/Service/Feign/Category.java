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
public class Category {

	private Long id;
    private String categoryName;
    private String description;
    private String status;
    private List<FoodItemsDto> foodItems = new ArrayList<>();
    private String publicCategoryId;

}

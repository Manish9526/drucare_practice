package com.hueged.hashedin.Order.Service.Feign;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemsDto {


    private Long id;
    private String foodName;
    private String description;
    private BigDecimal price;
    private String status;
    private Long restaurantId;
    private Long categoryId;
    private String publicFoodId;

}

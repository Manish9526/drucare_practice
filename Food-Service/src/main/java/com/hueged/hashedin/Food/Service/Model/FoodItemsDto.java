package com.hueged.hashedin.Food.Service.Model;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Setter
@Getter
@Schema(description = "Data Transfer Object for food items information")
public class FoodItemsDto {

    @Schema(description = "The unique identifier of the food item", nullable = true)
    private Long id;

    @Schema(description = "Name of the food item", nullable = true, example = "Margherita Pizza")
    private String foodName;

    @Schema(description = "Description of the food item", nullable = true, example = "Classic Italian pizza with fresh mozzarella and basil")
    private String description;

    @Schema(description = "Price of the food item", nullable = true, example = "15.99")
    private BigDecimal price;

    @Schema(description = "Current status of the food item", nullable = true, example = "Available")
    private String status;

    @Schema(description = "Identifier for the restaurant this food item belongs to", nullable = true)
    private Long restaurantId;

    @Schema(description = "Identifier for the category this food item belongs to", nullable = true)
    private Long categoryId;

    @Schema(description = "Public identifier for the food item", nullable = true)
    private String publicFoodId;

}

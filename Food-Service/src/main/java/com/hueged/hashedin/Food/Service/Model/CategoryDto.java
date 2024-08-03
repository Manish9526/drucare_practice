package com.hueged.hashedin.Food.Service.Model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Schema(description = "Data Transfer Object for category information")
public class CategoryDto {


    @Schema(description = "The unique identifier of the category", nullable = true)
    private Long id;

    @Schema(description = "Name of the category", nullable = true, example = "Italian Cuisine")
    private String categoryName;

    @Schema(description = "Description of the category", nullable = true, example = "Traditional and modern Italian dishes")
    private String description;

    @Schema(description = "Current status of the category", nullable = true, example = "Active")
    private String status;

    @Schema(description = "Public identifier for the category", nullable = true)
    private String publicCategoryId;

    @Schema(description = "List of food items in this category", nullable = true)
    private List<FoodItemsDto> foodItems;

}
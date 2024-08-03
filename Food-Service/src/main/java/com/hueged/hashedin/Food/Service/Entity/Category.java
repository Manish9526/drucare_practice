package com.hueged.hashedin.Food.Service.Entity;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "Represents a category of food items in the menu")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "The unique identifier of the category")
    private Long id;

    @Schema(description = "The name of the category", example = "Beverages")
    private String categoryName;

    @Schema(description = "A brief description of the category", example = "Includes all types of drinks")
    private String description;

    @Schema(description = "The current status of the category", example = "Active")
    private String status;

    @OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL)
    @Schema(description = "List of food items under this category")
    private List<FoodItems> foodItems = new ArrayList<>();

    @Schema(description = "Public facing unique identifier for the category")
    private String publicCategoryId;


}
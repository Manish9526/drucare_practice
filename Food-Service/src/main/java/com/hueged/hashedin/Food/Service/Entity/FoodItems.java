package com.hueged.hashedin.Food.Service.Entity;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "Represents an individual food item in the menu")
public class FoodItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "The unique identifier of the food item")
    private Long id;

    @Schema(description = "The name of the food item", example = "Cheese Pizza")
    private String foodName;

    @Schema(description = "A brief description of the food item", example = "A delicious cheese pizza with a crispy crust, topped with mozzarella and cheddar.")
    private String description;

    @Schema(description = "The price of the food item", example = "15.99")
    private BigDecimal price;

    @Schema(description = "The current status of the food item", example = "Available")
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    @Schema(description = "The category to which this food item belongs")
    private Category categoryId;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @Schema(description = "The restaurant that offers this food item")
    private Restaurant restaurantId;

    @Schema(description = "Public facing unique identifier for the food item")
    private String publicFoodId;

    // Constructors, getters, and setters
}
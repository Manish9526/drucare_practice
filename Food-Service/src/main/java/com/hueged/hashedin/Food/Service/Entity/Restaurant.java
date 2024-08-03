package com.hueged.hashedin.Food.Service.Entity;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Represents a restaurant in the system")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "The unique identifier of the restaurant",nullable = true, example = "null", defaultValue = "null")
    private Long id;

    @Schema(description = "The name of the restaurant", example = "Gourmet Bistro")
    private String restaurantName;

    @Schema(description = "The city where the restaurant is located", example = "San Francisco")
    private String city;

    @Schema(description = "The postal code of the restaurant's location", example = "94103")
    private String pincode;

    @Schema(description = "The email address of the restaurant", example = "contact@gourmetbistro.com")
    private String restaurantEmail;

    @Schema(description = "The current operational status of the restaurant", example = "Open")
    private String restaurantStatus;

    @OneToMany(mappedBy = "restaurantId")
    @Schema(description = "List of food items offered by the restaurant")
    private List<FoodItems> foodItemsList = new ArrayList<>();

    @Schema(description = "Public facing unique identifier for the restaurant",nullable = true, example = "null", defaultValue = "null")
    private String publicRestoId;

    // Constructors, getters, and setters
}
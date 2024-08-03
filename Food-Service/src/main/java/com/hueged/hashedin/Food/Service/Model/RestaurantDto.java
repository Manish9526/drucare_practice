package com.hueged.hashedin.Food.Service.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Schema(description = "Data Transfer Object for restaurant information")
public class RestaurantDto {


    @Schema(description = "The unique identifier of the restaurant", nullable = true)
    private Long id;

    @Schema(description = "Name of the restaurant", nullable = true, example = "Bikanary")
    private String restaurantName;

    @Schema(description = "City where the restaurant is located", nullable = true, example = "Pune")
    private String city;

    @Schema(description = "Postal code of the restaurant's location", nullable = true, example = "94103")
    private String pincode;

    @Schema(description = "Email address of the restaurant", nullable = true, example = "bikanary@gmail.com")
    private String restaurantEmail;

    @Schema(description = "Current operational status of the restaurant", nullable = true, example = "Open")
    private String restaurantStatus;

    @Schema(description = "Public identifier for the restaurant", nullable = true)
    private String publicRestoId;

}

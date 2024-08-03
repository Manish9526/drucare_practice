package com.hueged.hashedin.Order.Service.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Represents a Cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "The unique identifier of the Cart")
	private Long id;
	
	@Schema(description = "The User Id", example = "ee2b6a07-4d19-423a-aeba-ca6eaac66091")
	private String userId;
	
	@Schema(description = "The Food Id", example = "4b184251-222a-4f9a-95da-a4e8ddf6ce4a")
	private String foodId;
	@Schema(description = "The Food Quantity", example = "4")
	private Integer quantity;
	private String publicCartId;

}

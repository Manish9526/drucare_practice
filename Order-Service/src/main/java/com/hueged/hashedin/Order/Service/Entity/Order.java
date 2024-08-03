package com.hueged.hashedin.Order.Service.Entity;

import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")
@Schema(description = "Represents Order")
public class Order {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Schema(description = "The Order id", example = "06b42a4f-c69b-4047-bcae-c61be770d798")
	    private Long orderId;

	    @OneToOne
	    @JoinColumn(name = "cart_id", referencedColumnName = "id")
	    private Cart cart;

	    @Schema(description = "The Cart id", example = "ee2b6a07-4d19-423a-aeba-ca6eaac66091")
	    private String publicCartId;
	    
	    @Schema(description = "The Order Date", example = "ee2b6a07-4d19-423a-aeba-ca6eaac66091")
	    private Date orderDate;
	    
	    @Schema(description = "The Order Status", example = "Proccessing")
	    private String status;
	    
	    @Schema(description = "The Order Price", example = "500.50")
	    private Double price;
	    private String publicOrderId;
	    private String userId;
}

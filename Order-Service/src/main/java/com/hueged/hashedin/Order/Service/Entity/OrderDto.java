package com.hueged.hashedin.Order.Service.Entity;

import java.sql.Date;

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
public class OrderDto {

	  private CartDetailsDto cardDetails;
	    private Long orderId;
	    private Date orderDate;
	    private String status;
	    private Double price;
}

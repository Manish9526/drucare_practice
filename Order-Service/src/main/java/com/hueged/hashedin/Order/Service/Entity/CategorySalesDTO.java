package com.hueged.hashedin.Order.Service.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategorySalesDTO {

	 private String categoryName;
	    private Double totalSales;
	    
		public CategorySalesDTO(String categoryName, Double totalSales) {
			super();
			this.categoryName = categoryName;
			this.totalSales = totalSales;
		}
	    
	    

}

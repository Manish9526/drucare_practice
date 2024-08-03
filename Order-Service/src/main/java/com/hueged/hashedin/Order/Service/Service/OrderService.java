package com.hueged.hashedin.Order.Service.Service;

import java.util.List;

import com.hueged.hashedin.Order.Service.Entity.CategorySalesDTO;
import com.hueged.hashedin.Order.Service.Entity.DailyOrderStatusDTO;
import com.hueged.hashedin.Order.Service.Entity.Order;

public interface OrderService  {

	Order placeOrder(Order orderReq);

	Order findById(Long orderId);

	List<DailyOrderStatusDTO> getDailyOrderStatusSummary();

	List<CategorySalesDTO> getTopSellingCategory();

}

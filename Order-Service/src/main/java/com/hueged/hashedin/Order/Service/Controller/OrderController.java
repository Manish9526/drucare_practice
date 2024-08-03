package com.hueged.hashedin.Order.Service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hueged.hashedin.Order.Service.Entity.Order;
import com.hueged.hashedin.Order.Service.Entity.ResponseMapper;
import com.hueged.hashedin.Order.Service.Service.OrderService;
import com.hueged.hashedin.Order.Service.Utills.OrderUtills;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping ("/order")
@Tag(name = "Order Management", description = "Handle operations related to Order manegment and traking")
public class OrderController {

	@Autowired
	OrderUtills orderUtills;
	
	@Autowired
	OrderService orderService ;
	
	@PostMapping(path = "/placeorder")
	@Operation(summary = "Create the order place ")
	@ApiResponse(responseCode = "200", description = " Data Inserted Successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMapper.class)))
	public ResponseEntity<ResponseMapper> placeOrder(@RequestBody Order orderReq){
		return orderUtills.responseEntityForFetchSuccess(orderService.placeOrder(orderReq));
	}
	
	@PostMapping(path = "/cancelorder/{orderId}")
	@Operation(summary = "Cancel the order using the order id ")
	@ApiResponse(responseCode = "200", description = " Data Deleted Successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMapper.class)))
	public ResponseEntity<ResponseMapper> cancelOrder(@PathVariable Long orderId){
		return orderUtills.responseEntityForDelete(orderService.findById(orderId));
	}
	
	@GetMapping("/daily-status-summary")
	@Operation(summary = "Fetch all data")
	@ApiResponse(responseCode = "200", description = "Fetch The Date For Management", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMapper.class)))
	public ResponseEntity<ResponseMapper> getDailyOrderStatusSummary() {
         
        return orderUtills.responseEntityForFetchSuccess(orderService.getDailyOrderStatusSummary());
    }
	@GetMapping("/top-selling")
    public ResponseEntity<ResponseMapper> getTopSellingCategory() {
         
        return orderUtills.responseEntityForFetchSuccess(orderService.getTopSellingCategory());
    }
}

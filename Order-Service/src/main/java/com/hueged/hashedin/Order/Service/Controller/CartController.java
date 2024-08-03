package com.hueged.hashedin.Order.Service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.hueged.hashedin.Order.Service.Entity.Cart;
import com.hueged.hashedin.Order.Service.Entity.ResponseMapper;
import com.hueged.hashedin.Order.Service.Service.CartService;
import com.hueged.hashedin.Order.Service.Utills.OrderUtills;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/cart")
@Tag(name = "Cart Management", description = "Handle operations related to customer cart")
public class CartController {

	
	@Autowired
	CartService cartService;

	@Autowired
	OrderUtills orderUtills;
	
	@PostMapping(path = "/addtocart")
	@Operation(summary = "Create a Cart ")
	@ApiResponse(responseCode = "200", description = " Data Inserted Successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMapper.class)))
	public ResponseEntity<ResponseMapper> addToCart(@RequestBody Cart cartReq){
		return orderUtills.responseEntityForFetchSuccess(cartService.addToCart(cartReq));
	}
	
	@PutMapping("/updateCart")
	@Operation(summary = "Update the cart , add the new food in same cart")
	@ApiResponse(responseCode = "200", description = " Data Updated Successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMapper.class)))
	public ResponseEntity<ResponseMapper> updateCart(@RequestBody Cart cartReq){
		return orderUtills.responseEntityForFetchSuccess(cartService.updateCart(cartReq));
	}
	
	@GetMapping("/{cardId}")
	@Operation(summary = "Get the cart deatils base on the cart id ")
	@ApiResponse(responseCode = "200", description = " Data Fetch Successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMapper.class)))
	public ResponseEntity<ResponseMapper>  getCardDetails(@PathVariable String cardId){
		return orderUtills.responseEntityForFetchSuccess(cartService.getCardDetails(cardId));
	}
	
	
	
	
}

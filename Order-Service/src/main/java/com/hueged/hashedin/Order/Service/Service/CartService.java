package com.hueged.hashedin.Order.Service.Service;

import com.hueged.hashedin.Order.Service.Entity.Cart;
import com.hueged.hashedin.Order.Service.Entity.CartDetailsDto;
import com.hueged.hashedin.Order.Service.Entity.CartDto;

public interface CartService {

	CartDto addToCart(Cart cartReq);

	CartDto updateCart(Cart cartReq);

	CartDetailsDto getCardDetails(String cardId);

}

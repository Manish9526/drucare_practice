package com.hueged.hashedin.Order.Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hueged.hashedin.Order.Service.Entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	Cart findByPublicCartId(String cardId);

	
}

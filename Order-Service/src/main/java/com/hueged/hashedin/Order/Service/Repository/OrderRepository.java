package com.hueged.hashedin.Order.Service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hueged.hashedin.Order.Service.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order , Long>{

	List<Order> findAllByStatus(String string);
	

}

package com.hueged.hashedin.Order.Service.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hueged.hashedin.Food.Service.Entity.ResponseMapper;
import com.hueged.hashedin.Order.Service.Config.MailConfig;
import com.hueged.hashedin.Order.Service.Entity.Cart;
import com.hueged.hashedin.Order.Service.Entity.CategorySalesDTO;
import com.hueged.hashedin.Order.Service.Entity.DailyOrderStatusDTO;
import com.hueged.hashedin.Order.Service.Entity.Order;
import com.hueged.hashedin.Order.Service.Exception.NoOrderFoundException;
import com.hueged.hashedin.Order.Service.Exception.PastDateException;
import com.hueged.hashedin.Order.Service.Feign.UserDto;
import com.hueged.hashedin.Order.Service.Feign.UserServiceFeignClient;
import com.hueged.hashedin.Order.Service.Repository.CartRepository;
import com.hueged.hashedin.Order.Service.Repository.OrderRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class OrderServiceImpl implements OrderService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CartServiceImpl cartServiceImpl;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	MailConfig mailConfig;
	
	@Autowired
	CartRepository cartRepository;

	@Autowired
	UserServiceFeignClient userServiceFeignClient;
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Order placeOrder(Order orderReq) {
		
		 Cart cart = cartRepository.findByPublicCartId(orderReq.getPublicCartId());
		 orderReq.setCart(cart);
		 orderReq.setStatus("Processing");
		 orderReq.setPublicOrderId(UUID.randomUUID().toString());
		 
		 Order order =orderRepository.save(orderReq);
		 Date now = new Date();
		 SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");

		 String formattedToday = dt.format(now);
		 String formattedOrderDate = dt.format(orderReq.getOrderDate());

		 if (formattedOrderDate.compareTo(formattedToday) >= 0) { 
			mailConfig.sendMail();
		}else {
			throw new PastDateException("Order date cannot be in the past.");
		}


		return order;
	}
	@Override
	public Order findById(Long orderId) {
		
		Optional<Order> order=orderRepository.findById(orderId);
		
		if(order== null) {
			throw new NoOrderFoundException("order not found"); 
		}
		
		Order orderObj =order.get();
		orderObj.setStatus("Cancelled");
		orderRepository.save(orderObj);
		return orderObj;
	}
	
	@Override
	public List<DailyOrderStatusDTO> getDailyOrderStatusSummary() {
		
		String jpql = "SELECT new com.hueged.hashedin.Order.Service.Entity.DailyOrderStatusDTO(" +
	              "CAST(FUNCTION('DATE', o.orderDate) AS STRING) as orderDay, " +
	              "o.status, " +
	              "o.userId, " +
	              "COUNT(o)) " +
	              "FROM Order o " +
	              "GROUP BY CAST(FUNCTION('DATE', o.orderDate) AS STRING), o.status,o.userId " +
	              "ORDER BY CAST(FUNCTION('DATE', o.orderDate) AS STRING) DESC";
	
		
	TypedQuery<DailyOrderStatusDTO> query = entityManager.createQuery(jpql, DailyOrderStatusDTO.class);
	List<DailyOrderStatusDTO> mainList =query.getResultList();
	ModelMapper modelMapper = new ModelMapper();
	mainList.forEach(dto -> {
        if (dto.getUserId() != null) {
            ResponseMapper responseMapper= userServiceFeignClient.getSingleUser(dto.getUserId());
            UserDto userDto = modelMapper.map(responseMapper.getData(), UserDto.class);
            // Assuming getSingleUser returns a User object
            dto.setUserList(Collections.singletonList(userDto)); 
        } else {
            dto.setUserList(Collections.emptyList()); 
        }
    });

		return mainList;
	}
	
	
	@Scheduled(cron = "0 * * * * *") 
    public void updateOrderStatus() {
		logger.info("cron job started ");
        List<Order> orders = orderRepository.findAllByStatus("Processing"); 
		if (!orders.isEmpty()) {
			for (Order order : orders) {
				order.setStatus("Delivered");
				orderRepository.save(order);
			}

			mailConfig.sendMail(orders.get(0));
			logger.info("send mail for delivered");
		}
       
        
    }

	
	
	@Override
	public List<CategorySalesDTO> getTopSellingCategory() {
		
		return null;
	}



}

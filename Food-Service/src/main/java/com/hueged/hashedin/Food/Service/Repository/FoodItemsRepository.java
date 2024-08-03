package com.hueged.hashedin.Food.Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hueged.hashedin.Food.Service.Entity.FoodItems;
import com.hueged.hashedin.Food.Service.Entity.Restaurant;

@Repository
public interface FoodItemsRepository  extends JpaRepository<FoodItems, Long>{

	FoodItems findByPublicFoodId(String foodId);

	

}

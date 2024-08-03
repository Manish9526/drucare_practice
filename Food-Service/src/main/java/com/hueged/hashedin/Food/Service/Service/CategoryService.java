package com.hueged.hashedin.Food.Service.Service;

import com.hueged.hashedin.Food.Service.Entity.Category;
import com.hueged.hashedin.Food.Service.Model.CategoryDto;


public interface CategoryService {

	CategoryDto addCategory(CategoryDto categoryReq);

	CategoryDto findByPublicCategoryId(String categoryId);

	CategoryDto findByCategoryId(Long CategoryId);

	

}

package com.hueged.hashedin.Food.Service.Service;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hueged.hashedin.Food.Service.Entity.Category;
import com.hueged.hashedin.Food.Service.Entity.Restaurant;
import com.hueged.hashedin.Food.Service.Exceptions.NoCategoryFoundException;
import com.hueged.hashedin.Food.Service.Model.CategoryDto;
import com.hueged.hashedin.Food.Service.Repository.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	@Transactional
	public CategoryDto addCategory(CategoryDto categoryReq) {
		ModelMapper modelMapper = new ModelMapper();
		Category Category = modelMapper.map(categoryReq, Category.class);
		Category.setStatus("Activated");
		Category.setPublicCategoryId(UUID.randomUUID().toString());
	 Category=categoryRepository.save(Category);
		 categoryReq = modelMapper.map(Category, CategoryDto.class);
		return categoryReq ;
	}

	@Override
	public CategoryDto findByPublicCategoryId(String categoryId)  {
		 Category category = categoryRepository.findByPublicCategoryId(categoryId);
			if (category == null) {
				throw new NoCategoryFoundException("Category not found");
			}
			ModelMapper modelMapper = new ModelMapper();
			
			
		return modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto findByCategoryId(Long categoryId) {
		logger.info("inter the findByCategoryId methode:::::: "+categoryId+"");
		Optional<Category> category = categoryRepository.findById(categoryId);
		if(!category.isPresent()) {
			logger.info("Getting Exceptions");
			throw new NoCategoryFoundException("Category not found");
		}
		logger.info("fetch data successfully");
		ModelMapper modelMapper = new ModelMapper();
		
		
		return modelMapper.map(category.get(), CategoryDto.class) ;

	}

	

}

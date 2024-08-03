package com.hueged.hashedin.Food.Service.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hueged.hashedin.Food.Service.Entity.ResponseMapper;
import com.hueged.hashedin.Food.Service.Model.CategoryDto;
import com.hueged.hashedin.Food.Service.Service.CategoryService;
import com.hueged.hashedin.Food.Service.Utills.FoodServiceUtills;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/category")
@Tag(name = "Category Management", description = "Handle operations related to Food Category")
public class CategoryController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	FoodServiceUtills foodServiceUtills;
	

	@PostMapping(path = "/addcategory")
	@Operation(summary = "Create a Food Category")
	@ApiResponse(responseCode = "200", description = " Data Inserted Successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMapper.class)))
	public ResponseEntity<ResponseMapper> createCategory(@RequestBody CategoryDto CategoryReq){
		
		return foodServiceUtills.responseEntityForInsertSuccess(categoryService.addCategory(CategoryReq));
	
	}
	
	@GetMapping(path = "/categoryId/{categoryId}")
	@Operation(summary = "Get a category by ID")
	public ResponseEntity<ResponseMapper> findByCategoryId(@PathVariable Long categoryId){
		logger.info("inside the controller findByCategoryId methode");
		return foodServiceUtills.responseEntityForFetchSuccess(categoryService.findByCategoryId(categoryId));
	}
	
	@GetMapping(path = "/{categoryId}")
	@Operation(summary = "Get a category by ID")
	public ResponseEntity<ResponseMapper> getCategoryByPublicId(@PathVariable String categoryId){
		
		return foodServiceUtills.responseEntityForFetchSuccess(categoryService.findByPublicCategoryId(categoryId));
	}
	

	
}

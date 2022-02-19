package com.hungerz.hungerz.service;

import com.hungerz.hungerz.dto.CategoryDto;
import com.hungerz.hungerz.dto.RestaurantDto;
import com.hungerz.hungerz.entity.CategoryEntity;
import com.hungerz.hungerz.entity.RestaurantsEntity;
import com.hungerz.hungerz.repository.CategoryRepo;
import com.hungerz.hungerz.repository.RestaurantRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;
    private List<CategoryEntity> categoryList;
    Logger logger = LoggerFactory.getLogger(CategoryService.class);

    public CategoryEntity saveCategory(CategoryDto categoryDto) {

        CategoryEntity category = new CategoryEntity();
        category.setCategoryName(categoryDto.getCategoryName());
        category.setCategoryStatus(categoryDto.getCategoryStatus());
        logger.info("saved the category");
        return categoryRepo.save(category);

    }


    public List<CategoryEntity> getCategoryList() {
        return categoryRepo.findAll();
    }

    public CategoryEntity findCategoryById(long id) {
        return categoryRepo.findByCategoryId(id);
    }
}

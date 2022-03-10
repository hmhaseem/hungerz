package com.hungerz.hungerz.service;


import com.hungerz.hungerz.dto.CategoryDto;
import com.hungerz.hungerz.entity.CategoryEntity;
import com.hungerz.hungerz.repository.CategoryRepo;
import com.hungerz.hungerz.utility.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    Logger logger = LoggerFactory.getLogger(CategoryService.class);

    public CategoryEntity saveCategory(CategoryDto categoryDto) {

        CategoryEntity category = new CategoryEntity();
        category.setCategoryName(categoryDto.getCategoryName());
        category.setCategoryStatus(categoryDto.getCategoryStatus());
        logger.info("saved the category");
        return categoryRepo.save(category);

    }


    CommonResponse commonResponse = new CommonResponse();

    public List<CategoryEntity> getCategoryList() {
        return categoryRepo.findAll();
    }

    public CommonResponse findCategoryById(int id) {

        commonResponse.setMessage("Date retrieve from DB successfully");
        commonResponse.setStatus(true);
        commonResponse.setPayload(categoryRepo.findByCategoryId(id));
        return commonResponse;
    }

    public CommonResponse UpdateCategory(CategoryDto categoryDto) {
        try {
            Optional<CategoryEntity> categoryEntityOptional = categoryRepo.findByCategoryId(categoryDto.getCategoryId());

            if (categoryEntityOptional.isPresent()) {

                CategoryEntity categoryEntity = categoryEntityOptional.get();
                categoryEntity.setCategoryStatus(categoryDto.getCategoryStatus());
                categoryEntity.setCategoryName(categoryDto.getCategoryName());
                CategoryEntity category = categoryRepo.save(categoryEntity);
                commonResponse.setStatus(true);
                commonResponse.setMessage("Updated the date successfully");
                commonResponse.setPayload(category);
            } else {
                commonResponse.setStatus(false);
                commonResponse.setMessage("Failed to update the record ");

            }

        } catch (Exception e) {
            logger.info("There is some issue due this reason : {}", e.getMessage());
        }

        return commonResponse;

    }

    public CommonResponse deleteById(int id) {

        try {
            categoryRepo.deleteById(id);
            commonResponse.setMessage("Category deleted successfully");
            commonResponse.setStatus(true);
            return commonResponse;
        } catch (Exception e) {

            commonResponse.setStatus(false);
            commonResponse.setMessage("there is some issue due to this : " + e.getMessage());
            return commonResponse;

        }


    }
}

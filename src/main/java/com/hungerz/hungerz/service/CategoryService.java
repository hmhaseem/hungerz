package com.hungerz.hungerz.service;


import com.hungerz.hungerz.dto.CategoryDto;
import com.hungerz.hungerz.entity.CategoryEntity;
import com.hungerz.hungerz.repository.CategoryRepo;
import com.hungerz.hungerz.utility.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    Logger logger = LoggerFactory.getLogger(CategoryService.class);
    CommonResponse commonResponse = new CommonResponse();

    public CommonResponse saveCategory(CategoryDto categoryDto) {
        logger.info("saveCategory method accessed");
        try {
            CategoryEntity category = new CategoryEntity();
            category.setCategoryName(categoryDto.getCategoryName());
            category.setCategoryStatus(categoryDto.getCategoryStatus());
            categoryRepo.save(category);
            commonResponse.setPayload(category);
            commonResponse.setMessage("Category saved successfully");
            commonResponse.setStatus(true);
            logger.info("Category saved successfully.. ");
        } catch (Exception e) {
            commonResponse.setMessage("There something happened due to this " + e.getMessage());
            commonResponse.setStatus(false);
            logger.info("There something happened due to this {}", e.getMessage());
        }

        return commonResponse;

    }

    public CommonResponse getCategoryList() {
        commonResponse.setStatus(true);
        commonResponse.setPayload(categoryRepo.findAll());
        commonResponse.setMessage("Data Retrieved successfully");
        return commonResponse;
    }

    public CommonResponse findCategoryById(int id) {
        commonResponse.setMessage("Date retrieve from DB successfully");
        commonResponse.setStatus(true);
        commonResponse.setPayload(categoryRepo.findByCategoryId(id));
        return commonResponse;
    }

    public CommonResponse updateCategory(CategoryDto categoryDto) {
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
            commonResponse.setMessage("There is some issue due to this : " + e.getMessage());
            return commonResponse;
        }
    }
}

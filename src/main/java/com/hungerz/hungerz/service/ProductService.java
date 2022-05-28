package com.hungerz.hungerz.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hungerz.hungerz.dto.FoodDto;
import com.hungerz.hungerz.entity.Foods;
import com.hungerz.hungerz.repository.FoodRepo;
import com.hungerz.hungerz.utility.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    FoodRepo foodRepo;

    Logger logger = LoggerFactory.getLogger(ProductService.class);
    CommonResponse commonResponse = new CommonResponse();
    public final static String uploadDirectory = "C:\\Users\\HP\\Desktop\\final year\\material-dashboard\\src\\assets\\img";

    public CommonResponse saveProduct(FoodDto foodDto, MultipartFile file) {


        try {

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            Foods product = mapper.convertValue(foodDto, Foods.class);
            //  StringBuilder fileNames = new StringBuilder();
            String fileName = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDirectory, fileName);
            Files.write(fileNameAndPath, file.getBytes());
            product.setFile(fileName);
            Foods products = foodRepo.save(product);

            logger.info("Product saved successfully");
            commonResponse.setMessage("Product saved successfully");
            commonResponse.setPayload(products);
            commonResponse.setStatus(true);
        } catch (Exception e) {
            logger.info("There is something issue due to  : {}", e.getMessage());
            commonResponse.setMessage("There is something issue due to :" + e.getMessage());
            commonResponse.setStatus(false);
        }
        return commonResponse;

    }

    public CommonResponse findByProductId(int id) {
        Optional<Foods> product = foodRepo.findById(id);
        if (product.isPresent()) {
            commonResponse.setMessage("Product retrieved successfully...");
            commonResponse.setStatus(true);
            commonResponse.setPayload(product);
        } else {
            commonResponse.setMessage("Product not fount or something happened");
            commonResponse.setStatus(false);
        }

        return commonResponse;
    }

    public CommonResponse updateProduct(FoodDto foodDto, MultipartFile file) {
        try {

            Optional<Foods> product = foodRepo.findById(foodDto.getFoodId());

            if (product.isPresent()) {
                Foods foods = product.get();
                foods.setProductPrice(foodDto.getProductPrice());
                foods.setProductName(foodDto.getProductName());
                foods.setProductPrice(foodDto.getProductPrice());
                foods.setProductStatus(foodDto.getProductStatus());
                foods.setCategoryId(foodDto.getCategoryId());
                foods.setQty(1);
                String fileName = file.getOriginalFilename();
                Path fileNameAndPath = Paths.get(uploadDirectory, fileName);

                Files.write(fileNameAndPath, file.getBytes());

                foods.setFile(fileName);
                foodRepo.save(foods);
                commonResponse.setStatus(true);
                commonResponse.setMessage("Product updated successfully..");
                //  commonResponse.setPayload(foods);
                logger.info("Product updated successfully..");
            }
        } catch (Exception e) {
            commonResponse.setStatus(false);
            commonResponse.setMessage("There is some issue for updating process .....");
            logger.info("There is some issue for updating process .....");
        }
        return commonResponse;

    }


    public Foods getProductsById(int productId) {
        return foodRepo.getById(productId);
    }

    public CommonResponse getAllProducts() {
        commonResponse.setPayload(foodRepo.findAll());
        commonResponse.setStatus(true);
        commonResponse.setMessage("Data retrieved");
        return commonResponse;
    }

    public CommonResponse deleteById(int id) {
        try {
            foodRepo.deleteById(id);
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

package com.hungerz.hungerz.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hungerz.hungerz.dto.ProductDto;
import com.hungerz.hungerz.entity.ProductEntity;
import com.hungerz.hungerz.repository.ProductRepo;
import com.hungerz.hungerz.utility.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    Logger logger = LoggerFactory.getLogger(ProductService.class);
    CommonResponse commonResponse = new CommonResponse();

    public CommonResponse saveProduct(ProductDto productDto) {


        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            ProductEntity product = mapper.convertValue(productDto, ProductEntity.class);
            ProductEntity products = productRepo.save(product);
            logger.info("Product saved successfully");
            commonResponse.setMessage("Product saved successfully");
            commonResponse.setPayload(products);
            commonResponse.setStatus(true);
        } catch (Exception e) {
            logger.info("There is something issue due to  : {}", e.getMessage());
            commonResponse.setMessage("There is something issue due to :" + e.getMessage());
            commonResponse.setStatus(true);
        }
        return commonResponse;

    }

    public CommonResponse findByProductId(int id) {
        Optional<ProductEntity> product = productRepo.findById(id);
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

    public CommonResponse updateProduct(ProductDto productDto) {


        Optional<ProductEntity> product = productRepo.findById(productDto.getCategoryId());

        if (product.isPresent()) {
            ProductEntity productEntity = product.get();
            productEntity.setProductPrice(productDto.getProductPrice());
            productEntity.setProductName(productDto.getProductName());
            productEntity.setProductPrice(productDto.getProductPrice());
            productEntity.setProductStatus(productDto.getProductStatus());
            productRepo.save(productEntity);
            commonResponse.setStatus(true);
            commonResponse.setMessage("Product updated successfully..");
            commonResponse.setPayload(productEntity);
            logger.info("Product updated successfully..");
        }
        commonResponse.setStatus(false);
        commonResponse.setMessage("There is some issue for updating process .....");
        logger.info("There is some issue for updating process .....");
        return commonResponse;
    }


}

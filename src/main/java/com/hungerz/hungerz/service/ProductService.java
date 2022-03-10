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


@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    Logger logger = LoggerFactory.getLogger(ProductService.class);

    public CommonResponse saveProduct(ProductDto productDto) {

        CommonResponse commonResponse = new CommonResponse();
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

    
}

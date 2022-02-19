package com.hungerz.hungerz.service;

import com.hungerz.hungerz.dto.ProductDto;
import com.hungerz.hungerz.entity.ProductEntity;
import com.hungerz.hungerz.repository.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    Logger logger = LoggerFactory.getLogger(ProductService.class);

    public ProductEntity saveProduct(ProductDto productDto) {

        ProductEntity product = new ProductEntity();
        product.setProductPrice(productDto.getProductPrice());
        product.setProductName(productDto.getProductName());
        product.setProductStatus(productDto.getProductStatus());
        product.setProductPrice(productDto.getProductPrice());
        product.setCategoryId(productDto.getCategoryId());
        logger.info("Product saved successfully");
        return productRepo.save(product);

    }
}

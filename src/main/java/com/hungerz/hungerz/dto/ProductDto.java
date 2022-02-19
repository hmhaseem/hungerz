package com.hungerz.hungerz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {


    private int categoryId;
    private String productName;
    private String productPrice;
    private String productStatus;

}

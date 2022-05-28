package com.hungerz.hungerz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodDto {

    private int foodId;
    private int categoryId;
    private int qty;
    private String productName;
    private String productPrice;
    private String productStatus;


}

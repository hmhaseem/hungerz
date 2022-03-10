package com.hungerz.hungerz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private int categoryId;
    private String categoryName;
    private String categoryStatus;
}

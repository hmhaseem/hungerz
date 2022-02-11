package com.hungerz.hungerz.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;
    private String categoryName;
    private String categoryStatus;


}

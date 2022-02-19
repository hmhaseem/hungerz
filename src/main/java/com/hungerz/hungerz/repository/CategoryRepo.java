package com.hungerz.hungerz.repository;

import com.hungerz.hungerz.entity.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer>, JpaSpecificationExecutor<CategoryEntity> {

    CategoryEntity findByCategoryId(long id);
}

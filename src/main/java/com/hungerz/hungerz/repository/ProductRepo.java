package com.hungerz.hungerz.repository;

import com.hungerz.hungerz.entity.CategoryEntity;
import com.hungerz.hungerz.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer>, JpaSpecificationExecutor<ProductEntity> {


}

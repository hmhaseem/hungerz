package com.hungerz.hungerz.repository;

import com.hungerz.hungerz.entity.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer>, JpaSpecificationExecutor<CategoryEntity> {



    Optional<CategoryEntity> findByCategoryId(int id);

    void deleteById(int id);


}

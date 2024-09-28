package com.example.demo.infrastructure.repositories.category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

}

package com.example.demo.infrastructure.repositories.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entity.Productos;

@Repository
public interface ProductRepository extends CrudRepository<Productos, Integer>{
    
}

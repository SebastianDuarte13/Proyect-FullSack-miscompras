package com.example.demo.infrastructure.repositories.customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entity.Customers;

@Repository
public interface CustomerRepository extends CrudRepository<Customers, Long>{

}

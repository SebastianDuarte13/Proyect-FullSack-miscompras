package com.example.demo.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.application.services.ICustomersServices;
import com.example.demo.domain.entity.Customers;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private ICustomersServices customersServices;

    @GetMapping
    public List<Customers> list(){
        return customersServices.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Customers> customerOptional = customersServices.findById(id);
        return customerOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Customers customers) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customersServices.save(customers));
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Customers customers) {
        Optional<Customers> updateCustomer = customersServices.update(id, customers);
        return updateCustomer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
          Optional<Customers> deleteCustomer = customersServices.delete(id);
          return deleteCustomer.map(c -> ResponseEntity.ok().build()).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

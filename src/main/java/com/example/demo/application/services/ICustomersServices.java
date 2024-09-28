package com.example.demo.application.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.demo.domain.entity.Customers;

@Service
public interface ICustomersServices {
    List<Customers> findAll();

    Optional<Customers> findById(Long id);

    Customers save(Customers customers);

    Optional<Customers> update(Long id, Customers customers);

    Optional<Customers> delete(Long id);
}

package com.example.demo.infrastructure.repositories.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.application.services.ICustomersServices;
import com.example.demo.domain.entity.Customers;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomerImpl implements ICustomersServices{
    @Autowired
    private CustomerRepository customerRepository;


    @Transactional(readOnly = true)
    @Override
    public List<Customers> findAll() {
        return (List<Customers>) customerRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Customers> findById(Long id) {
       return customerRepository.findById(id);
    }

    @Transactional
    @Override
    public Customers save(Customers customers) {
        return customerRepository.save(customers);
    }

    @Transactional
    @Override
    public Optional<Customers> update(Long id, Customers customers) {
        return customerRepository.findById(id).map(existingCustomer -> {
            existingCustomer.setNombre(customers.getNombre());
            existingCustomer.setApellidos(customers.getApellidos());
            existingCustomer.setCelular(customers.getCelular());
            existingCustomer.setDireccion(customers.getDireccion());
            existingCustomer.setCorreo_electronico(customers.getCorreo_electronico());
            return customerRepository.save(existingCustomer);
        });
    }

    @Override
    public Optional<Customers> delete(Long id) {
        return customerRepository.findById(id).map(existingCustomer -> {
            customerRepository.delete(existingCustomer);
            return existingCustomer;
        });
    }

}

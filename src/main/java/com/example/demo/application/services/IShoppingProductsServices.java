package com.example.demo.application.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.demo.domain.entity.ShoppingProducts;

@Service
public interface IShoppingProductsServices {
  List<ShoppingProducts> findAll();

    Optional<ShoppingProducts> findById(Long id);

    ShoppingProducts save(ShoppingProducts shoppingProducts);

    Optional<ShoppingProducts> update(Long id, ShoppingProducts shoppingProducts);

    Optional<ShoppingProducts> delete(Long id);
}

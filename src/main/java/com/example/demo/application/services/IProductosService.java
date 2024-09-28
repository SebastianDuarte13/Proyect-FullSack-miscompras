package com.example.demo.application.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.demo.domain.entity.Productos;

@Service
public interface IProductosService {

    List<Productos> findAll();

    Optional<Productos> findById(int id_producto);

    Productos save(Productos productos);

    Optional<Productos> update(int id_producto, Productos productos);

    Optional<Productos> delete(int id_producto);
}

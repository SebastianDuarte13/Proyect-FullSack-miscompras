package com.example.demo.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.example.demo.application.services.IProductosService;
import com.example.demo.domain.entity.Productos;


@RestController
@RequestMapping("/api/productos")
public class ProductController {
    @Autowired
    private IProductosService productosService;

    @GetMapping
    public List<Productos> list() {
        return productosService.findAll();
    }

    @GetMapping("/{id_producto}")
    public ResponseEntity<?> view(@PathVariable int id_producto) {
        Optional<Productos> productosOptional = productosService.findById(id_producto);
        return productosOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Productos productos) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productosService.save(productos));
    }

    @PutMapping("/{id_producto}")
    public ResponseEntity<?> update(@PathVariable int id_producto, @RequestBody Productos productos) {
        Optional<Productos> updatedProduct = productosService.update(id_producto, productos);
        return updatedProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id_producto}")
    public ResponseEntity<?> delete(@PathVariable int id_producto) {
        Optional<Productos> productosDelete = productosService.delete(id_producto);
        return productosDelete.map(c -> ResponseEntity.ok().build()).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

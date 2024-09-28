package com.example.demo.infrastructure.repositories.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.application.services.IProductosService;
import com.example.demo.domain.entity.Productos;

@Service
public class ProductImpl implements IProductosService{

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Productos> findAll() {
        return (List<Productos>)productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Productos> findById(int id_producto) {
        return productRepository.findById(id_producto);
    }

    @Transactional
    @Override
    public Productos save(Productos productos) {
        return productRepository.save(productos);
    }

    @Transactional
    @Override
    public Optional<Productos> update(int id_producto, Productos productos) {
        Optional<Productos> productOld = productRepository.findById(id_producto);
        if(productOld.isPresent()){
            Productos productosDb = productOld.orElseThrow();

            productosDb.setNombre(productos.getNombre());
            productosDb.setId_categoria(productos.getId_categoria());
            productosDb.setCodigo_barras(productos.getCodigo_barras());
            productosDb.setPrecio_venta(productos.getPrecio_venta());
            productosDb.setCantidad_stock(productos.getCantidad_stock());
            productosDb.setEstado(productos.getEstado());

            return Optional.of(productRepository.save(productos));
        }
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Productos> delete(int id_producto) {
        Optional<Productos> productOptional = productRepository.findById(id_producto);
        productOptional.ifPresent(productosDb -> {
            productRepository.delete(productosDb);
        });
        return productOptional;
    }
    
}

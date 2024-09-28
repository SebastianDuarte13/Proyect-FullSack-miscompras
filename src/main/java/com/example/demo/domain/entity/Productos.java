package com.example.demo.domain.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products")
@Data 
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id_producto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "id_categoria")
    private int id_categoria;

    @Column(name = "codigo_barras")
    private String codigo_barras;

    @Column(name = "precio_venta")
    private int precio_venta;

    @Column(name = "cantidad_stock")
    private int cantidad_stock;

    @Column(name = "estado")
    private Byte estado;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}

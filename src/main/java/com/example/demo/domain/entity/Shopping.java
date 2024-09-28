package com.example.demo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.Data;


@Entity
@Table(name = "shopping")
@Data
public class Shopping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private int id;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "medio_pago")
    private Byte medioPago;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "estado")
    private Byte estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Customers customer; 
    
}
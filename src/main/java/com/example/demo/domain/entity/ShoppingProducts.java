package com.example.demo.domain.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shopping_products")
@Data 
public class ShoppingProducts {

    @EmbeddedId
    private ShoppingProductsId id;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "total")
    private int total;

    @Column(name = "estado")
    private int estado;

    @ManyToOne
    @JoinColumn(name = "id_shopping", insertable = false, updatable = false)
    private Shopping shopping;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", columnDefinition = "varchar(255)", insertable = false, updatable = false)
    private Productos producto;

    @Embeddable
    @Data 
    @NoArgsConstructor 
    @AllArgsConstructor 
    public static class ShoppingProductsId implements Serializable {

        @Column(name = "id_shopping")
        private int idShopping;

        @Column(name = "id_producto")
        private int idProduct;
    }
}

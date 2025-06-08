package com.example.NoLimits.Multimedia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Pedido")
@NoArgsConstructor
@AllArgsConstructor
public class ProductoModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String nombre;

    @Column(nullable=false)
    private String descripcion;

    @Column(nullable=false)
    private Float precio;

    @Column(nullable=false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name="estadoVenta_id")
    private EstadoDeVenta estadoDeVenta;
}

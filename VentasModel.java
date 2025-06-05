package com.example.NoLimits.Multimedia.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ventas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentasModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable= true)
    private String nombre;
    
    @Column(nullable = true)
    private LocalDate fechaCompra;

    @Column(nullable = false)
    private LocalTime horaCompra;

    @Column(nullable = false)
    private Integer totalVenta;

    /* 
    @ManyToOne
    @JoinColumn(name = "Metodo de pago", nullable = false)
    private MetodoPago metodo;

    @ManyToOne
    @JoinColumn(name = "Estado de Venta", nullable = false)
    private EstadoDeVenta estadoDeVenta;
    */
}

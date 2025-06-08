package com.example.NoLimits.Multimedia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NoLimits.Multimedia.model.EstadoDeVenta;

@Repository
public interface EstadoDeVentaRepository extends JpaRepository<EstadoDeVenta, Long>{

     Optional<EstadoDeVenta> findByEstado(String estado);
    
        // Verificar si existe un estado
        boolean existsByEstado(String estado);
}

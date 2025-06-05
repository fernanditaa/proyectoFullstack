package com.example.NoLimits.Multimedia.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.NoLimits.Multimedia.model.VentasModel;

@Repository
public interface VentasRepository extends JpaRepository<VentasModel, Long>{

    @Query("""
            
            SELECT v.id, v.nombre, v.fechaCompra, v.horaCompra, v.totalVenta FROM VentasModel v
            """)

    List<VentasModel> findByFechaCompra(LocalDate FechaCompra);

    VentasModel findByHoraCompra(LocalTime HoraCompra);

    VentasModel findById(Integer id);
}

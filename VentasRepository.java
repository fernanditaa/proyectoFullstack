package com.example.NoLimits.Multimedia.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NoLimits.Multimedia.model.VentasModel;

@Repository
public interface VentasRepository extends JpaRepository<VentasModel, Long>{

    List<VentasModel> findByFechaCompra(LocalDate FechaCompra);

    VentasModel findByHoracompra(LocalTime HoraCompra);

    VentasModel findById(Integer id);
}

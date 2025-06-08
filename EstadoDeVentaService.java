package com.example.NoLimits.Multimedia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NoLimits.Multimedia.model.EstadoDeVenta;
import com.example.NoLimits.Multimedia.repository.EstadoDeVentaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EstadoDeVentaService {

    @Autowired
    private EstadoDeVentaRepository estadoDeVentaRepository;

    public List<EstadoDeVenta> findAll(){
        return estadoDeVentaRepository.findAll();
    }

    public EstadoDeVenta findById(Long id) {
        Optional<EstadoDeVenta> estadoDeVenta = estadoDeVentaRepository.findById(id);
        return estadoDeVenta.orElse(null);
    }

    //Guardar un nuevo estado de venta
    public EstadoDeVenta crear(EstadoDeVenta estadoDeVenta) {
        return estadoDeVentaRepository.save(estadoDeVenta);
    }

    //Eliminar un estado de venta por su ID
    public boolean eliminar(Long id) {
        Optional<EstadoDeVenta> estadoDeVenta = estadoDeVentaRepository.findById(id);
        if (estadoDeVenta.isPresent()) {
            estadoDeVentaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //Actualizar un estado de venta por su ID
    public EstadoDeVenta actualizar(Long id, EstadoDeVenta estadoDeVenta) {
        Optional<EstadoDeVenta> estadoDeVentaExistente = estadoDeVentaRepository.findById(id);
        if (estadoDeVentaExistente.isPresent()) {
            EstadoDeVenta estadoV = estadoDeVentaExistente.get();
            
            estadoV.setEstado(estadoDeVenta.getEstado());
            
            return estadoDeVentaRepository.save(estadoV);
        }
        return null;
    }






}

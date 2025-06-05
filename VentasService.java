package com.example.NoLimits.Multimedia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NoLimits.Multimedia.model.VentasModel;
import com.example.NoLimits.Multimedia.repository.VentasRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    public List<VentasModel> findAll(){
        return ventasRepository.findAll();
    }

    public VentasModel findByuId(long id){
        return ventasRepository.getById(id);
    }

    public VentasModel save(VentasModel ventas){
        return ventasRepository.save(ventas);
    }

    public void deleteById(long id){
        ventasRepository.deleteById(id);
    }

    public VentasModel patchVentasModel(Long id, VentasModel parcialVentasModel){
        Optional <VentasModel> ventaOptional = ventasRepository.findById(id);
        if (ventaOptional.isPresent()){
            VentasModel venta = ventaOptional.get();
            if(parcialVentasModel.getNombre() != null) {
            venta.setNombre(parcialVentasModel.getNombre());
            }
            if(parcialVentasModel.getFechaCompra() != null){
                venta.setFechaCompra(parcialVentasModel.getFechaCompra());
            }
            if(parcialVentasModel.getHoraCompra() !=null){
                venta.setHoraCompra(parcialVentasModel.getHoraCompra());
            }
            if(parcialVentasModel.getTotalVenta() != null){
                venta.setTotalVenta(parcialVentasModel.getTotalVenta());
            }
            return  ventasRepository.save(venta);
            }else{
                return null;
            }
    }
}

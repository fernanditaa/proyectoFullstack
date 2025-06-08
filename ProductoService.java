package com.example.NoLimits.Multimedia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NoLimits.Multimedia.model.ProductoModel;
import com.example.NoLimits.Multimedia.repository.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<ProductoModel> findAll(){
        return productoRepository.findAll();
    }

    public ProductoModel findById(Long id){
        return productoRepository.getById(id);
    }

    public ProductoModel save(ProductoModel producto){
        return productoRepository.save(producto);
    }

    public void deleteById(long id){
        productoRepository.deleteById(id);
    }

    public ProductoModel patchProductoModel(Long id, ProductoModel parcialProductoModel){
        Optional<ProductoModel> productoOptional = productoRepository.findById(id);
        
        if(productoOptional.isPresent()){
            ProductoModel producto = productoOptional.get();

            if(parcialProductoModel.getNombre()!= null){
                producto.setNombre(parcialProductoModel.getNombre());
            }
            if(parcialProductoModel.getPrecio()!= null){
                producto.setDescripcion(parcialProductoModel.getDescripcion());
            }
            if(parcialProductoModel.getPrecio()!= null){
                producto.setPrecio(parcialProductoModel.getPrecio());
            }
            if(parcialProductoModel.getStock()!= null){
                producto.setStock(parcialProductoModel.getStock());
            }
            return productoRepository.save(producto);
        } else {
            return null;
        }
    }
}

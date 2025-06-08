package com.example.NoLimits.Multimedia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.NoLimits.Multimedia.model.ProductoModel;


@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Long> {
    
    @Query("""
            SELECT p FROM ProductoModel p
            
            """)
    List<ProductoModel> findByNombre(String nombre);
    
    ProductoModel findById(Integer id);

}
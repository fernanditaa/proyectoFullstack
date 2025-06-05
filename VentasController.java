package com.example.NoLimits.Multimedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.NoLimits.Multimedia.model.VentasModel;
import com.example.NoLimits.Multimedia.service.VentasService;


@Controller
@RequestMapping("/api/v1/ventas")
public class VentasController {

    @Autowired
    private VentasService ventasService;

    @GetMapping
    public ResponseEntity<List<VentasModel>> listar(){
        List<VentasModel> ventas = ventasService.findAll();
        if(ventas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
            return ResponseEntity.ok(ventas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentasModel> buscar(@PathVariable Long id){
        try {
            VentasModel ventas = ventasService.findByuId(id);
            return ResponseEntity.ok(ventas);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<VentasModel> crear(@RequestBody VentasModel ventas){
        VentasModel nuevaVenta = ventasService.save(ventas);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentasModel> actulizar(@PathVariable Long id, @RequestBody VentasModel ventas){
        try{
            VentasModel ventasActualizado = ventasService.patchVentasModel(id, ventas);
            return ResponseEntity.ok(ventasActualizado);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PatchMapping("/{id}")
    public ResponseEntity<VentasModel> editarVenta(@PathVariable Long id, @RequestBody VentasModel venta){
        try {
            VentasModel ventaActualizado = ventasService.patchVentasModel(id, venta);
            return ResponseEntity.ok(ventaActualizado);
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try {
            ventasService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

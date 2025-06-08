package com.example.NoLimits.Multimedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.NoLimits.Multimedia.model.EstadoDeVenta;
import com.example.NoLimits.Multimedia.service.EstadoDeVentaService;

@Controller
@RequestMapping("/api/v1/estadoDeVentas")
public class EstdoDeVentasController {

    @Autowired
    private EstadoDeVentaService estadoDeVentaService;

    @GetMapping
    public ResponseEntity<List<EstadoDeVenta>> findAll() {
        List<EstadoDeVenta> estadosDeVenta = estadoDeVentaService.findAll();
        if (estadosDeVenta.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estadosDeVenta);
    }

    //Obtener un estado de venta por ID
    @GetMapping("/{id}")
    public ResponseEntity<EstadoDeVenta> obtenerPorId(@PathVariable Long id) {
        EstadoDeVenta estado = estadoDeVentaService.findById(id);
        if (estado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estado);
    }
    //Crear un nuevo estado de venta
    @PostMapping
    public ResponseEntity<EstadoDeVenta> crear(@RequestBody EstadoDeVenta estado){
        EstadoDeVenta nuevoEstado = estadoDeVentaService.crear(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstado);
    }
    
    //Actualizar estado de venta
    @PutMapping("/{id}")
    public ResponseEntity<EstadoDeVenta> actualizar(@PathVariable Long id, @RequestBody EstadoDeVenta estadoDeVenta) {
        try{
            
            EstadoDeVenta estado = estadoDeVentaService.actualizar(id, estadoDeVenta);
            return ResponseEntity.ok(estado);
        }catch(Exception e){
        return ResponseEntity.notFound().build();
        }
    }

    //Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = estadoDeVentaService.eliminar(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

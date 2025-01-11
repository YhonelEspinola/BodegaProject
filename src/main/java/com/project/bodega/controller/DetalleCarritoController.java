package com.project.bodega.controller;

import com.project.bodega.Dto.DetalleCarritoDTO;
import com.project.bodega.mapper.CarritoMapper;
import com.project.bodega.model.CarritoEntity;
import com.project.bodega.model.DetalleCarritoEntity;
import com.project.bodega.service.CarritoService;
import com.project.bodega.service.DetalleCarritoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/detalle-carrito")
public class DetalleCarritoController {
    @Autowired
    private DetalleCarritoService detalleCarritoService;
    @Autowired
    private CarritoService carritoService;

    @GetMapping("/{idCarrito}")
    public ResponseEntity<List<DetalleCarritoEntity>> getDetalleByCarrito(@PathVariable Long idCarrito) {
        CarritoEntity carrito = carritoService.getCarritoById(idCarrito);

        if (carrito != null) {
            List<DetalleCarritoEntity> detalles = detalleCarritoService.getDetalleByCarrito(carrito);
            return ResponseEntity.ok(detalles);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<DetalleCarritoDTO> createDetalleCarrito(@RequestBody DetalleCarritoDTO detalleDTO) {
        DetalleCarritoEntity detalle = detalleCarritoService.saveDetalleCarrito(CarritoMapper.detalleCarritoDTOToEntity(detalleDTO));
        return ResponseEntity.ok(CarritoMapper.detalleCarritoEntityToDTO(detalle));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleCarritoDTO> updateDetalleCarrito(@PathVariable Long id, @RequestBody DetalleCarritoDTO detalleDTO) {
        DetalleCarritoEntity detalle = detalleCarritoService.updateDetalleCarrito(id, CarritoMapper.detalleCarritoDTOToEntity(detalleDTO));
        return detalle != null ? ResponseEntity.ok(CarritoMapper.detalleCarritoEntityToDTO(detalle)) : ResponseEntity.notFound().build();
    }
}

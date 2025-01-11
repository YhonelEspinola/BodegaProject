package com.project.bodega.controller;

import com.project.bodega.Dto.CarritoDTO;
import com.project.bodega.mapper.CarritoMapper;
import com.project.bodega.model.CarritoEntity;
import com.project.bodega.model.UsuarioEntity;
import com.project.bodega.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/carrito")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<CarritoDTO> getCarritoByUsuario(@PathVariable Long idUsuario) {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setIdUsuario(idUsuario);

        CarritoEntity carrito = carritoService.getCarritoByUsuario(usuario);

        if (carrito != null) {
            return ResponseEntity.ok(CarritoMapper.carritoEntityToDTO(carrito));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<CarritoDTO> createCarrito(@RequestBody CarritoDTO carritoDTO) {
        CarritoEntity carrito = carritoService.saveCarrito(CarritoMapper.carritoDTOToEntity(carritoDTO));
        return ResponseEntity.ok(CarritoMapper.carritoEntityToDTO(carrito));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarritoDTO> updateCarrito(@PathVariable Long id, @RequestBody CarritoDTO carritoDTO) {
        CarritoEntity carrito = carritoService.updateCarrito(id, CarritoMapper.carritoDTOToEntity(carritoDTO));
        return carrito != null ? ResponseEntity.ok(CarritoMapper.carritoEntityToDTO(carrito)) : ResponseEntity.notFound().build();
    }

}

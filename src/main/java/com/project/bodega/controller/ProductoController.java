package com.project.bodega.controller;

import com.project.bodega.Dto.ProductoDTO;
import com.project.bodega.mapper.Mapper;
import com.project.bodega.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private Mapper mapper;

    @GetMapping("/listar")
    public ResponseEntity<List<ProductoDTO>> getAllProductos() {
        List<ProductoDTO> productos = productoService.getAllProductos()
                .stream()
                .map(mapper::toProductoDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getProductoById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toProductoDTO(productoService.getProductoById(id)));
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> createProducto(@RequestBody ProductoDTO productoDTO) {
        return ResponseEntity.ok(mapper.toProductoDTO(productoService.saveProducto(mapper.toProductoEntity(productoDTO))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> updateProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
        return ResponseEntity.ok(mapper.toProductoDTO(productoService.updateProducto(id, mapper.toProductoEntity(productoDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductoDTO>> searchProductos(@RequestParam String nombre) {
        List<ProductoDTO> productos = productoService.getProductosByNombre(nombre)
                .stream()
                .map(mapper::toProductoDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/categoria/{idCategoria}")
    public ResponseEntity<List<ProductoDTO>> getProductosByCategoria(@PathVariable Long idCategoria) {
        List<ProductoDTO> productos = productoService.getProductosByCategoria(idCategoria)
                .stream()
                .map(mapper::toProductoDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productos);
    }

}

package com.project.bodega.controller;

import com.project.bodega.Dto.CategoriaDTO;
import com.project.bodega.mapper.Mapper;
import com.project.bodega.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private Mapper mapper;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getAllCategorias() {
        List<CategoriaDTO> categorias = categoriaService.getAllCategorias()
                .stream()
                .map(mapper::toCategoriaDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> getCategoriaById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toCategoriaDTO(categoriaService.getCategoriaById(id)));
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        return ResponseEntity.ok(mapper.toCategoriaDTO(categoriaService.saveCategoria(mapper.toCategoriaEntity(categoriaDTO))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> updateCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        return ResponseEntity.ok(mapper.toCategoriaDTO(categoriaService.updateCategoria(id, mapper.toCategoriaEntity(categoriaDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }

}

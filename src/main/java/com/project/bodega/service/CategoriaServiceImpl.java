package com.project.bodega.service;

import com.project.bodega.model.CategoriaEntity;
import com.project.bodega.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaEntity> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public CategoriaEntity getCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public CategoriaEntity saveCategoria(CategoriaEntity categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public CategoriaEntity updateCategoria(Long id, CategoriaEntity categoria) {
        Optional<CategoriaEntity> existingCategoria = categoriaRepository.findById(id);
        if (existingCategoria.isPresent()) {
            CategoriaEntity updatedCategoria = existingCategoria.get();
            updatedCategoria.setNombre(categoria.getNombre());
            return categoriaRepository.save(updatedCategoria);
        }
        return null;
    }

    @Override
    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}

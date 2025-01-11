package com.project.bodega.service;

import com.project.bodega.model.CategoriaEntity;

import java.util.List;

public interface CategoriaService {

    List<CategoriaEntity> getAllCategorias();
    CategoriaEntity getCategoriaById(Long id);
    CategoriaEntity saveCategoria(CategoriaEntity categoria);
    CategoriaEntity updateCategoria(Long id, CategoriaEntity categoria);
    void deleteCategoria(Long id);

}

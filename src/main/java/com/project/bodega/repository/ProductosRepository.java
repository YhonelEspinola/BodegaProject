package com.project.bodega.repository;

import com.project.bodega.model.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductosRepository extends JpaRepository<ProductoEntity, Long> {

    List<ProductoEntity> findByNombreContaining(String nombre);
}

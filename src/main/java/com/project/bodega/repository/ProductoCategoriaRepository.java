package com.project.bodega.repository;

import com.project.bodega.model.CategoriaEntity;
import com.project.bodega.model.ProductCategoriaEntity;
import com.project.bodega.model.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoCategoriaRepository extends JpaRepository<ProductoCategoriaRepository, Long>{

    List<ProductCategoriaEntity> findCategoria(CategoriaEntity categoriaEntity);

    List<ProductoEntity> findByIdProductosIn(List<Long> idCategoria);

}

package com.project.bodega.repository;

import com.project.bodega.model.CategoriaEntity;
import com.project.bodega.model.ProductCategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoCategoriaRepository extends JpaRepository<ProductCategoriaEntity, Long>{

    List<ProductCategoriaEntity> findByCategoria(CategoriaEntity categoria);

    List<Long> findIdProductosByCategoria(CategoriaEntity categoria);
}

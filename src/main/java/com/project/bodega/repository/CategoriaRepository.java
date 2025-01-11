package com.project.bodega.repository;

import com.project.bodega.model.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {


}

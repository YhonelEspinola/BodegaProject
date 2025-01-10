package com.project.bodega.repository;

import com.project.bodega.model.CategoriaEntity;
import com.project.bodega.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository<CarritoRepository, Long>{

    CategoriaEntity findByUsuario(UsuarioEntity usuario);

}

package com.project.bodega.repository;

import com.project.bodega.model.CarritoEntity;
import com.project.bodega.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository<CarritoEntity, Long>{

    CarritoEntity findByUsuario(UsuarioEntity usuario);

}

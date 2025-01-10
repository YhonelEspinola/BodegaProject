package com.project.bodega.repository;

import com.project.bodega.model.CarritoEntity;
import com.project.bodega.model.DetalleCarritoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleCarritoRepository extends JpaRepository<DetalleCarritoRepository, Long>{

    List<DetalleCarritoEntity> findByCarrito(CarritoEntity carrito);

}

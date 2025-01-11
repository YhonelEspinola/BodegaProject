package com.project.bodega.service;

import com.project.bodega.model.CarritoEntity;
import com.project.bodega.model.DetalleCarritoEntity;

import java.util.List;

public interface DetalleCarritoService {

    List<DetalleCarritoEntity> getDetalleByCarrito(CarritoEntity carrito);
    DetalleCarritoEntity saveDetalleCarrito(DetalleCarritoEntity detalle);
    DetalleCarritoEntity updateDetalleCarrito(Long id,DetalleCarritoEntity detalle);

}

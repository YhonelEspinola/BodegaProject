package com.project.bodega.service;

import com.project.bodega.model.CarritoEntity;
import com.project.bodega.model.UsuarioEntity;

public interface CarritoService {

    CarritoEntity getCarritoByUsuario(UsuarioEntity usuario);
    CarritoEntity saveCarrito(CarritoEntity carrito);
    CarritoEntity updateCarrito(Long id,CarritoEntity carrito);
    CarritoEntity getCarritoById(Long id);

}

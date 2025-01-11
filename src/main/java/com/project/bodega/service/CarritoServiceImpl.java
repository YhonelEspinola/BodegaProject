package com.project.bodega.service;

import com.project.bodega.model.CarritoEntity;
import com.project.bodega.model.UsuarioEntity;
import com.project.bodega.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarritoServiceImpl implements CarritoService{

    @Autowired
    private CarritoRepository carritoRepository;

    @Override
    public CarritoEntity getCarritoByUsuario(UsuarioEntity usuario) {

        return carritoRepository.findByUsuario(usuario);
    }

    @Override
    public CarritoEntity saveCarrito(CarritoEntity carrito) {
        return carritoRepository.save(carrito);
    }

    @Override
    public CarritoEntity updateCarrito(Long id, CarritoEntity carrito) {
        Optional<CarritoEntity> existingCarrito = carritoRepository.findById(id);

        if (existingCarrito.isPresent()) {
            CarritoEntity updatedCarrito = existingCarrito.get();


            if (carrito.getUsuario() != null) {
                updatedCarrito.setUsuario(carrito.getUsuario());
            }
            if (carrito.getFechaCreacion() != null) {
                updatedCarrito.setFechaCreacion(carrito.getFechaCreacion());
            }


            return carritoRepository.save(updatedCarrito);
        }

        return null;
    }

    @Override
    public CarritoEntity getCarritoById(Long id) {
        Optional<CarritoEntity> carrito = carritoRepository.findById(id);
        return carrito.orElse(null);
    }

}

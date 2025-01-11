package com.project.bodega.service;

import com.project.bodega.model.CarritoEntity;
import com.project.bodega.model.DetalleCarritoEntity;
import com.project.bodega.repository.DetalleCarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleCarritoServiceImpl implements DetalleCarritoService{
    @Autowired
    private DetalleCarritoRepository detalleCarritoRepository;
    @Override
    public List<DetalleCarritoEntity> getDetalleByCarrito(CarritoEntity carrito) {
        return detalleCarritoRepository.findByCarrito(carrito);
    }

    @Override
    public DetalleCarritoEntity saveDetalleCarrito(DetalleCarritoEntity detalle) {
        return detalleCarritoRepository.save(detalle);
    }

    @Override
    public DetalleCarritoEntity updateDetalleCarrito(Long id, DetalleCarritoEntity detalle) {
        Optional<DetalleCarritoEntity> existingDetalle = detalleCarritoRepository.findById(id);

        if (existingDetalle.isPresent()) {
            DetalleCarritoEntity updatedDetalle = existingDetalle.get();

            // Actualiza los campos necesarios
            if (detalle.getCantidad() > 0) {
                updatedDetalle.setCantidad(detalle.getCantidad());
            }
            if (detalle.getPrecioTotal() > 0) {
                updatedDetalle.setPrecioTotal(detalle.getPrecioTotal());
            }
            if (detalle.getProducto() != null) {
                updatedDetalle.setProducto(detalle.getProducto());
            }

            // Guarda y retorna el detalle actualizado
            return detalleCarritoRepository.save(updatedDetalle);
        }

        // Si no se encuentra el detalle, retorna null o lanza una excepción
        throw new RuntimeException("Detalle del carrito no encontrado con ID: " + id);
    }

}

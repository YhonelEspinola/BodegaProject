package com.project.bodega.mapper;

import com.project.bodega.Dto.CarritoDTO;
import com.project.bodega.Dto.DetalleCarritoDTO;
import com.project.bodega.model.CarritoEntity;
import com.project.bodega.model.DetalleCarritoEntity;
import com.project.bodega.model.ProductoEntity;
import com.project.bodega.model.UsuarioEntity;

public class CarritoMapper {
    public static CarritoEntity carritoDTOToEntity(CarritoDTO carritoDTO) {
        CarritoEntity carrito = new CarritoEntity();
        carrito.setIdCarrito(carritoDTO.getIdCarrito());
        carrito.setFechaCreacion(carritoDTO.getFechaCreacion());

        if (carritoDTO.getIdUsuario() != null) {
            UsuarioEntity usuario = new UsuarioEntity();
            usuario.setIdUsuario(carritoDTO.getIdUsuario());
            carrito.setUsuario(usuario);
        }
        return carrito;
    }

    public static DetalleCarritoEntity detalleCarritoDTOToEntity(DetalleCarritoDTO detalleDTO) {
        DetalleCarritoEntity detalle = new DetalleCarritoEntity();
        detalle.setIdDetalleCarrito(detalleDTO.getIdDetalleCarrito());
        detalle.setCantidad(detalleDTO.getCantidad());
        detalle.setPrecioTotal(detalleDTO.getPrecioTotal());

        // Aquí asignamos las relaciones con las entidades CarritoEntity y ProductoEntity
        if (detalleDTO.getIdCarrito() != null) {
            CarritoEntity carrito = new CarritoEntity();
            carrito.setIdCarrito(detalleDTO.getIdCarrito());
            detalle.setCarrito(carrito);
        }

        if (detalleDTO.getIdProductos() != null) {
            ProductoEntity producto = new ProductoEntity();
            producto.setIdProductos(detalleDTO.getIdProductos());
            detalle.setProducto(producto);
        }

        return detalle;
    }

    public static CarritoDTO carritoEntityToDTO(CarritoEntity carrito) {
        CarritoDTO dto = new CarritoDTO();
        dto.setIdCarrito(carrito.getIdCarrito());
        dto.setIdUsuario(carrito.getUsuario().getIdUsuario());
        dto.setFechaCreacion(carrito.getFechaCreacion());
        return dto;
    }

    public static DetalleCarritoDTO detalleCarritoEntityToDTO(DetalleCarritoEntity detalle) {
        DetalleCarritoDTO dto = new DetalleCarritoDTO();
        dto.setIdDetalleCarrito(detalle.getIdDetalleCarrito());
        dto.setCantidad(detalle.getCantidad());
        dto.setPrecioTotal(detalle.getPrecioTotal());
        dto.setFechaRegistro(detalle.getFechaRegistro());
        dto.setIdCarrito(detalle.getCarrito().getIdCarrito());
        dto.setIdProductos(detalle.getProducto().getIdProductos());
        return dto;
    }
}

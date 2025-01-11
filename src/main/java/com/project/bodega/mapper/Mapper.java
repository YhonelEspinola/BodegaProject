package com.project.bodega.mapper;

import com.project.bodega.Dto.CategoriaDTO;
import com.project.bodega.Dto.ProductoDTO;
import com.project.bodega.model.CategoriaEntity;
import com.project.bodega.model.ProductoEntity;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    // Categoria
    public CategoriaDTO toCategoriaDTO(CategoriaEntity categoria) {
        return new CategoriaDTO(categoria.getId(), categoria.getNombre());
    }

    public CategoriaEntity toCategoriaEntity(CategoriaDTO dto) {
        return new CategoriaEntity(dto.getId(), dto.getNombre());
    }

    // Producto
    public ProductoDTO toProductoDTO(ProductoEntity producto) {
        return new ProductoDTO(
                producto.getIdProductos(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getImagenUrl(),
                producto.getStock(),
                producto.getFechaCreacion()
        );
    }

    public ProductoEntity toProductoEntity(ProductoDTO dto) {
        return new ProductoEntity(
                dto.getIdProductos(),
                dto.getNombre(),
                dto.getDescripcion(),
                dto.getPrecio(),
                dto.getImagenUrl(),
                dto.getStock(),
                dto.getFechaCreacion()
        );
    }
}

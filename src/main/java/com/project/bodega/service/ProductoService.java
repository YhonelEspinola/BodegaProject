package com.project.bodega.service;

import com.project.bodega.model.ProductoEntity;

import java.util.List;

public interface ProductoService {
    List<ProductoEntity> getAllProductos() ;
    ProductoEntity getProductoById(Long id) ;
    ProductoEntity saveProducto(ProductoEntity producto) ;
    ProductoEntity updateProducto(Long id, ProductoEntity producto) ;
    void deleteProducto(Long id) ;
    List<ProductoEntity> getProductosByNombre(String nombre);
    List<ProductoEntity> getProductosByCategoria(Long idCategoria) ;
}

package com.project.bodega.service;

import com.project.bodega.model.CategoriaEntity;
import com.project.bodega.model.ProductCategoriaEntity;
import com.project.bodega.model.ProductoEntity;
import com.project.bodega.repository.CategoriaRepository;
import com.project.bodega.repository.ProductoCategoriaRepository;
import com.project.bodega.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProductoCategoriaRepository productoCategoriaRepository;


    @Override
    public List<ProductoEntity> getAllProductos() {
        return productosRepository.findAll();
    }

    @Override
    public ProductoEntity getProductoById(Long id) {
        return productosRepository.findById(id).orElse(null);
    }

    @Override
    public ProductoEntity saveProducto(ProductoEntity producto) {
        return productosRepository.save(producto);
    }

    @Override
    public ProductoEntity updateProducto(Long id, ProductoEntity producto) {
        Optional<ProductoEntity> existingProducto = productosRepository.findById(id);
        if (existingProducto.isPresent()) {
            ProductoEntity updatedProducto = existingProducto.get();
            updatedProducto.setNombre(producto.getNombre());
            updatedProducto.setDescripcion(producto.getDescripcion());
            updatedProducto.setPrecio(producto.getPrecio());
            updatedProducto.setStock(producto.getStock());
            updatedProducto.setImagenUrl(producto.getImagenUrl());
            return productosRepository.save(updatedProducto);
        }
        return null;
    }

    @Override
    public void deleteProducto(Long id) {
        productosRepository.deleteById(id);
    }

    @Override
    public List<ProductoEntity> getProductosByNombre(String nombre) {
        return productosRepository.findByNombreContaining(nombre);
    }

    @Override
    public List<ProductoEntity> getProductosByCategoria(Long idCategoria) {
        CategoriaEntity categoria = categoriaRepository.findById((long) idCategoria).orElse(null);

        if (categoria != null) {

            List<ProductCategoriaEntity> relaciones = productoCategoriaRepository.findByCategoria(categoria);


            return relaciones.stream()
                    .map(relacion -> {
                        ProductoEntity productoEntity = relacion.getProducto();
                        ProductoEntity producto = new ProductoEntity();
                        producto.setIdProductos(productoEntity.getIdProductos());
                        producto.setNombre(productoEntity.getNombre());
                        producto.setDescripcion(productoEntity.getDescripcion());
                        producto.setPrecio(productoEntity.getPrecio());
                        producto.setImagenUrl(productoEntity.getImagenUrl());
                        producto.setStock(productoEntity.getStock());
                        producto.setFechaCreacion(productoEntity.getFechaCreacion());
                        return producto;
                    })
                    .toList();
        }
        return null;
    }
}

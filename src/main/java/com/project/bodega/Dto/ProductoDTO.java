package com.project.bodega.Dto;



import java.time.LocalDateTime;



public class ProductoDTO {
    private Long idProductos;
    private String nombre;
    private String descripcion;
    private double precio;
    private String imagenUrl;
    private int stock;
    private LocalDateTime fechaCreacion;

    public ProductoDTO() {
    }

    public ProductoDTO(Long idProductos, String nombre, String descripcion, double precio, String imagenUrl, int stock, LocalDateTime fechaCreacion) {
        this.idProductos = idProductos;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagenUrl = imagenUrl;
        this.stock = stock;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(Long idProductos) {
        this.idProductos = idProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}

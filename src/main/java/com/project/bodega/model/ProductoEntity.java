package com.project.bodega.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "productos")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProductos;

    private String nombre;
    private String descripcion;
    @Column(nullable = false)
    private double precio;
    @Column(name = "imagen_url")
    private String imagenUrl;
    @Column(nullable = false)
    private int stock;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;


}

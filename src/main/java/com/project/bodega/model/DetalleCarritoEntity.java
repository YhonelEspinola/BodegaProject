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
@Table(name = "detalle_carrito")
public class DetalleCarritoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleCarrito;

    @Column(nullable = false)
    private int cantidad;

    @Column(name = "precio_total", nullable = false)
    private double precioTotal;

    @Column(name="fecha_registro", updatable  = false)
    private LocalDateTime fechaRegistro;

    @ManyToOne
    @JoinColumn(name="idCarrito", nullable = false)
    private CarritoEntity carrito;

    @ManyToOne
    @JoinColumn(name="idProductos", nullable = false)
    private ProductoEntity producto;

}

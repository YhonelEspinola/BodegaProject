package com.project.bodega.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedidos")
public class DetallePedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdDetallePedido;

    @Column(nullable = false)
    private int cantidad;

    @Column( name = "precio_total",nullable = false)
    private double precioTotal;

    @ManyToOne
    @JoinColumn(name="idPedidos", nullable = false)
    private PedidoEntity pedido;

    @ManyToOne
    @JoinColumn(name="idProductos", nullable = false)
    private ProductoEntity producto;


}

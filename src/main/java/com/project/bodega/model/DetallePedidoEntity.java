package com.project.bodega.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "detalle_pedidos")
public class DetallePedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdDetallePedido;

    @Column(nullable = false)
    private int cantidad;

    @Column( name = "precio_total",nullable = false)
    private double precioTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedidos", nullable = false)
    @JsonIgnore
    private PedidoEntity pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_productos", nullable = false)
    @JsonIgnore
    private ProductoEntity producto;

    public Long getIdDetallePedido() {
        return IdDetallePedido;
    }

    public void setIdDetallePedido(Long idDetallePedido) {
        IdDetallePedido = idDetallePedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public PedidoEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEntity pedido) {
        this.pedido = pedido;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }
}

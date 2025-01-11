package com.project.bodega.Dto;

import lombok.Data;

import java.time.LocalDateTime;


public class PedidoDTO {
    private Long idPedidos;
    private String estado;
    private LocalDateTime fechaPedido;
    private double total;
    private Long idUsuario;

    public Long getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(Long idPedidos) {
        this.idPedidos = idPedidos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}

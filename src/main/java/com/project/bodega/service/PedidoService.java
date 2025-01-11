package com.project.bodega.service;

import com.project.bodega.model.PedidoEntity;

import java.util.List;

public interface PedidoService {
    List<PedidoEntity> getAllPedidos() ;
    PedidoEntity getPedidoById(Long id) ;
    PedidoEntity savePedido(PedidoEntity pedido) ;
    PedidoEntity updatePedido(Long id, PedidoEntity pedido) ;
    void deletePedido(Long id) ;
    List<PedidoEntity> getPedidosByEstado(PedidoEntity.EstadoPedido estado);
}

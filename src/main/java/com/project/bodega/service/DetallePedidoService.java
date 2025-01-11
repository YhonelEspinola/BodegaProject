package com.project.bodega.service;

import com.project.bodega.model.DetallePedidoEntity;
import com.project.bodega.model.PedidoEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DetallePedidoService {
    List<DetallePedidoEntity> getDetallesByPedido(PedidoEntity pedido);
    DetallePedidoEntity saveDetallePedido(DetallePedidoEntity detallePedido);
    DetallePedidoEntity updateDetallePedido(Long id, DetallePedidoEntity detallePedido);

}

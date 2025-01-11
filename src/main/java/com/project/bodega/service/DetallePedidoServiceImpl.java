package com.project.bodega.service;

import com.project.bodega.model.DetallePedidoEntity;
import com.project.bodega.model.PedidoEntity;
import com.project.bodega.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DetallePedidoServiceImpl implements DetallePedidoService{
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Override
    public List<DetallePedidoEntity> getDetallesByPedido(PedidoEntity pedido) {
        return detallePedidoRepository.findByPedido(pedido);
    }

    @Override
    public DetallePedidoEntity saveDetallePedido(DetallePedidoEntity detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    @Override
    public DetallePedidoEntity updateDetallePedido(Long id, DetallePedidoEntity detallePedido) {
        return detallePedidoRepository.findById(id).map(existingDetalle -> {
            if (detallePedido.getCantidad() > 0) {
                existingDetalle.setCantidad(detallePedido.getCantidad());
            }
            if (detallePedido.getPrecioTotal() > 0) {
                existingDetalle.setPrecioTotal(detallePedido.getPrecioTotal());
            }
            if (detallePedido.getPedido() != null) {
                existingDetalle.setPedido(detallePedido.getPedido());
            }
            if (detallePedido.getProducto() != null) {
                existingDetalle.setProducto(detallePedido.getProducto());
            }
            return detallePedidoRepository.save(existingDetalle);
        }).orElseThrow(() -> new IllegalArgumentException("DetallePedido no encontrado"));
    }

}

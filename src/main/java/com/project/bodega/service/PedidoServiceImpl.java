package com.project.bodega.service;

import com.project.bodega.model.PedidoEntity;
import com.project.bodega.repository.PedidoRepository;
import com.project.bodega.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProductosRepository productoRepository;

    @Override
    public List<PedidoEntity> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public PedidoEntity getPedidoById(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public PedidoEntity savePedido(PedidoEntity pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public PedidoEntity updatePedido(Long id, PedidoEntity pedido) {
        Optional<PedidoEntity> existingPedido = pedidoRepository.findById(id);

        if (existingPedido.isPresent()) {
            PedidoEntity updatedPedido = existingPedido.get();


            if (pedido.getTotal() > 0) {
                updatedPedido.setTotal(pedido.getTotal());
            }

            if (pedido.getEstado() != null) {
                updatedPedido.setEstado(pedido.getEstado());
            }

            return pedidoRepository.save(updatedPedido);
        }

        return null;
    }

    @Override
    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public List<PedidoEntity> getPedidosByEstado(PedidoEntity.EstadoPedido estado) {
        return pedidoRepository.findByEstado(estado);
    }


}

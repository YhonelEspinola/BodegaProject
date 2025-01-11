package com.project.bodega.mapper;

import com.project.bodega.Dto.PedidoDTO;
import com.project.bodega.model.PedidoEntity;
import com.project.bodega.model.UsuarioEntity;

public class PedidoMapper {
    public static PedidoEntity toEntity(PedidoDTO dto, UsuarioEntity usuario) {
        PedidoEntity pedido = new PedidoEntity();
        pedido.setIdPedidos(dto.getIdPedidos());
        pedido.setEstado(PedidoEntity.EstadoPedido.valueOf(dto.getEstado()));  // Convierte String a Enum
        pedido.setFechaPedido(dto.getFechaPedido());
        pedido.setTotal(dto.getTotal());
        pedido.setUsuario(usuario);
        return pedido;
    }

    public static PedidoDTO toDTO(PedidoEntity entity) {
        PedidoDTO dto = new PedidoDTO();
        dto.setIdPedidos(entity.getIdPedidos());
        dto.setEstado(entity.getEstado().toString());  // Convierte Enum a String
        dto.setFechaPedido(entity.getFechaPedido());
        dto.setTotal(entity.getTotal());
        dto.setIdUsuario(entity.getUsuario().getIdUsuario());
        return dto;
    }
}

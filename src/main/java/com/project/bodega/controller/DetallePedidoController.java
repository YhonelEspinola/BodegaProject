package com.project.bodega.controller;

import com.project.bodega.Dto.DetallePedidoDTO;
import com.project.bodega.model.DetallePedidoEntity;
import com.project.bodega.model.PedidoEntity;
import com.project.bodega.model.ProductoEntity;
import com.project.bodega.service.DetallePedidoService;
import com.project.bodega.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/detalle-pedidos")
public class DetallePedidoController {
    @Autowired
    private DetallePedidoService detallePedidoService;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/{pedidoId}")
    public ResponseEntity<List<DetallePedidoDTO>> getDetallesByPedido(@PathVariable Long pedidoId) {
        PedidoEntity pedido = pedidoService.getPedidoById(pedidoId);
        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }

        List<DetallePedidoDTO> detalles = detallePedidoService.getDetallesByPedido(pedido).stream().map(detalle -> {
            DetallePedidoDTO dto = new DetallePedidoDTO();
            dto.setIdDetallePedido(detalle.getIdDetallePedido());
            dto.setCantidad(detalle.getCantidad());
            dto.setPrecioTotal(detalle.getPrecioTotal());
            dto.setIdPedidos(detalle.getPedido().getIdPedidos());
            dto.setIdProductos(detalle.getProducto().getIdProductos());
            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(detalles);
    }

    @PostMapping
    public ResponseEntity<DetallePedidoDTO> createDetalle(@RequestBody DetallePedidoDTO dto) {
        DetallePedidoEntity detalle = new DetallePedidoEntity();
        detalle.setCantidad(dto.getCantidad());
        detalle.setPrecioTotal(dto.getPrecioTotal());
        detalle.setPedido(pedidoService.getPedidoById(dto.getIdPedidos()));
        detalle.setProducto(new ProductoEntity(dto.getIdProductos(), null, null, 0, null, 0, null));

        DetallePedidoEntity savedDetalle = detallePedidoService.saveDetallePedido(detalle);
        DetallePedidoDTO response = new DetallePedidoDTO();
        response.setIdDetallePedido(savedDetalle.getIdDetallePedido());
        response.setCantidad(savedDetalle.getCantidad());
        response.setPrecioTotal(savedDetalle.getPrecioTotal());
        response.setIdPedidos(savedDetalle.getPedido().getIdPedidos());
        response.setIdProductos(savedDetalle.getProducto().getIdProductos());
        return ResponseEntity.ok(response);
    }
}

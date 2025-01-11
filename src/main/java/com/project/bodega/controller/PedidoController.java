package com.project.bodega.controller;

import com.project.bodega.Dto.PedidoDTO;
import com.project.bodega.mapper.PedidoMapper;
import com.project.bodega.model.PedidoEntity;
import com.project.bodega.model.UsuarioEntity;
import com.project.bodega.service.PedidoService;
import com.project.bodega.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getAllPedidos() {
        List<PedidoDTO> pedidos = pedidoService.getAllPedidos()
                .stream()
                .map(PedidoMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> getPedidoById(@PathVariable Long id) {
        PedidoEntity pedido = pedidoService.getPedidoById(id);
        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(PedidoMapper.toDTO(pedido));
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> createPedido(@RequestBody PedidoDTO dto) {
        UsuarioEntity usuario = usuarioService.getUsuarioById(dto.getIdUsuario());
        if (usuario == null) {
            return ResponseEntity.badRequest().build();
        }

        PedidoEntity pedido = PedidoMapper.toEntity(dto, usuario);
        PedidoEntity savedPedido = pedidoService.savePedido(pedido);
        return ResponseEntity.ok(PedidoMapper.toDTO(savedPedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> updatePedido(@PathVariable Long id, @RequestBody PedidoDTO dto) {
        UsuarioEntity usuario = usuarioService.getUsuarioById(dto.getIdUsuario());
        if (usuario == null) {
            return ResponseEntity.badRequest().build();
        }

        PedidoEntity pedido = PedidoMapper.toEntity(dto, usuario);
        PedidoEntity updatedPedido = pedidoService.updatePedido(id, pedido);
        if (updatedPedido == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(PedidoMapper.toDTO(updatedPedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        pedidoService.deletePedido(id);
        return ResponseEntity.noContent().build();
    }
}

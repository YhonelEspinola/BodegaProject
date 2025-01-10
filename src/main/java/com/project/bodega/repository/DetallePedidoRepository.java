package com.project.bodega.repository;

import com.project.bodega.model.DetallePedidoEntity;
import com.project.bodega.model.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedidoRepository, Long>{

    List<DetallePedidoEntity> findByPedido(PedidoEntity pedido);

}

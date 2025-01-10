package com.project.bodega.repository;

import com.project.bodega.model.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoRepository, Long> {

    List<PedidoEntity> findByEstado(PedidoEntity.EstadoPedido estado);

}

package com.fp.security.libreria.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fp.security.libreria.model.entityBeans.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}

package com.fp.security.libreria.modelo.dao;

import com.fp.security.libreria.model.entityBeans.Libro;
import com.fp.security.libreria.model.entityBeans.Pedido;

public interface PedidoDao {

	Pedido verPedido(int idPedido);
	int altaPedido(Pedido pedido);
}

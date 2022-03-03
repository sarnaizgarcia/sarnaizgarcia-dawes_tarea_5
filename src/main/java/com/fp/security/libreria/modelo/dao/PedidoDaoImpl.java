package com.fp.security.libreria.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fp.security.libreria.model.entityBeans.Pedido;
import com.fp.security.libreria.model.repository.PedidoRepository;

@Repository
public class PedidoDaoImpl implements PedidoDao {

	@Autowired
	PedidoRepository pRepo;
	
	@Override
	public Pedido verPedido(int idPedido) {
		return pRepo.findById(idPedido).orElse(null);
	}
	
	@Override
	public int altaPedido(Pedido pedido) {
		if (verPedido(pedido.getIdPedido()) == null) {
			pRepo.save(pedido);
			return 1;
		} else {
			return 0;
		}
	}

}

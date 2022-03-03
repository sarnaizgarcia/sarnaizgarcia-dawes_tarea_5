package com.fp.security.libreria.modelo.dao;

import java.util.List;

import com.fp.security.libreria.model.entityBeans.Usuario;

public interface UsuarioDao {

	List<Usuario> findAll();

	Usuario findById(String username);
	
}

package com.fp.security.libreria.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fp.security.libreria.model.entityBeans.Usuario;
import com.fp.security.libreria.model.repository.UsuarioRepository;

@Repository
public class UsuarioDaoImplMy8 implements UsuarioDao {
	@Autowired
	private UsuarioRepository urepo;

	@Override
	public Usuario findById(String username) {
		// TODO Auto-generated method stub
		return urepo.findById(username).orElse(null);
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return urepo.findAll();
	}

}

package com.fp.security.libreria.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fp.security.libreria.model.entityBeans.Libro;
import com.fp.security.libreria.model.repository.LibrosRepository;

@Repository
public class LibroDaoImpl implements LibroDao{

	@Autowired
	LibrosRepository lrepo;
	
	@Override
	public List<Libro> findAll() {
		// TODO Auto-generated method stub
		return lrepo.findAll();
	}

	@Override
	public Libro verUno(long isbn) {
		// TODO Auto-generated method stub
		return lrepo.findById(isbn).orElse(null);
	}

}

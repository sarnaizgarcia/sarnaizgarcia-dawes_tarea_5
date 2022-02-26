package com.fp.security.libreria.modelo.dao;

import java.util.List;

import com.fp.security.libreria.model.entityBeans.Libro;

public interface LibroDao {

	List<Libro> findAll();
	Libro verUno(long isbn);
	
}

package com.fp.security.libreria.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fp.security.libreria.model.entityBeans.Libro;
import com.fp.security.libreria.model.repository.LibroRepository;

@Repository
public class LibroDaoImpl implements LibroDao {

	@Autowired
	LibroRepository lrepo;

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

	@Override
	public int modificarLibro(Libro libro) {
		// TODO Auto-generated method stub
		if (verUno(libro.getIsbn()) != null) {
			lrepo.save(libro);
			return 1;
		} else
			return 0;
	}

	@Override
	public int eliminarLibro(long isbn) {
		// TODO Auto-generated method stub
		if (verUno(isbn) != null) {
			lrepo.deleteById(isbn);
			return 1;
		} else
			return 0;
	}

	@Override
	public int altaLibro(Libro libro) {
		// TODO Auto-generated method stub
		if (verUno(libro.getIsbn()) == null) {
			lrepo.save(libro);
			return 1;
		} else
			return 0;
	}

}

package com.fp.security.libreria.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fp.security.libreria.model.entityBeans.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

	@Query("select l from Libro l where l.novedad='s'")
	List<Libro> verNovedades();
	
	@Query("select l from Libro l where lower(l.tema.descTema) like lower (concat('%', :nombreTema,'%'))")
	List<Libro> buscarPorTema(String nombreTema);

	@Query("select l from Libro l where lower(l.titulo) like lower (concat('%', :palabra,'%'))")
	List<Libro> buscarPorPalabra(String palabra);

}

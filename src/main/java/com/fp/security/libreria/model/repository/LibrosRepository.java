package com.fp.security.libreria.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fp.security.libreria.model.entityBeans.Libro;

public interface LibrosRepository extends JpaRepository<Libro, Long>{

}

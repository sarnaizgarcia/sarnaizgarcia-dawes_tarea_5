package com.fp.security.libreria.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fp.security.libreria.model.entityBeans.Perfile;
import com.fp.security.libreria.model.repository.PerfilesRepository;

@Repository
public class PerfilesDaoImp implements PerfilesDao {

	@Autowired
	PerfilesRepository prepo;

	@Override
	public List<Perfile> findAll() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}

}

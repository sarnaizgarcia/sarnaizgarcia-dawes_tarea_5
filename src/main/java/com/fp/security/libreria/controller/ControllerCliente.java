package com.fp.security.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fp.security.libreria.modelo.dao.LibroDao;

@Controller
@RequestMapping("/cliente")
public class ControllerCliente {

	@Autowired
	LibroDao ldao;

	@GetMapping("/verDetalle/{isbn}")
	public String procDetalle(Model model, @PathVariable("isbn") long isbn) {
		model.addAttribute("listaLibros", ldao.verUno(isbn));
		System.out.println(ldao.verUno(isbn));
		return "verUnLibro";
	}

}

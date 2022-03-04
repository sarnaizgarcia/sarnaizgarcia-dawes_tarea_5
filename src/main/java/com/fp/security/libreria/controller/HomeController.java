package com.fp.security.libreria.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fp.security.libreria.model.entityBeans.Usuario;
import com.fp.security.libreria.model.repository.LibroRepository;
import com.fp.security.libreria.modelo.dao.LibroDao;
import com.fp.security.libreria.modelo.dao.UsuarioDao;

@Controller
public class HomeController {

	@Autowired
	LibroDao ldao;
	@Autowired
	LibroRepository lrepo;
	@Autowired
	UsuarioDao udao;

	@GetMapping("/")
	public String verNovedades(Model model) {
		model.addAttribute("listaLibros", lrepo.verNovedades());
		return "listaNovedades";

	}

	@GetMapping("/index")
	public String procesarLogin(Authentication aut, Model model, HttpSession misesion) {
		Usuario usuario = udao.findById(aut.getName());

		if (misesion.getAttribute("usuario") == null)
			misesion.setAttribute("usuario", usuario);

		model.addAttribute("mensaje", aut.getAuthorities());

		return "redirect:/";
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}

}

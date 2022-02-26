package com.fp.security.libreria.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	@GetMapping("/")
	public String verTodos(Model model) {

		return "listaNovedades";

	}

	/*@GetMapping("/index")
	public String procesarLogin(Authentication aut, Model model, HttpSession misesion) {

		System.out.println("usuario : " + aut.getName());
		Usuario usuario = udao.findById(aut.getName());

		if (misesion.getAttribute("usuario") == null)
			misesion.setAttribute("usuario", usuario);

		System.out.println();

		for (GrantedAuthority ele : aut.getAuthorities())
			System.out.println("ROL : " + ele.getAuthority());

		model.addAttribute("mensaje", aut.getAuthorities());

		return "redirect:/";
	}*/

}

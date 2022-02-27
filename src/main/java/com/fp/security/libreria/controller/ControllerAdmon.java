package com.fp.security.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fp.security.libreria.model.entityBeans.Libro;
import com.fp.security.libreria.modelo.dao.LibroDao;
import com.fp.security.libreria.modelo.dao.PerfilesDao;
import com.fp.security.libreria.modelo.dao.TemaDao;
import com.fp.security.libreria.modelo.dao.UsuarioDao;

@Controller
@RequestMapping("/admon")
public class ControllerAdmon {

	@Autowired
	LibroDao ldao;
	@Autowired
	TemaDao tdao;
	@Autowired
	UsuarioDao udao;
	@Autowired
	PerfilesDao pdao;

	@GetMapping("/editar/{isbn}")
	public String procEditarLibro(Model model, @PathVariable("isbn") long isbn) {
		model.addAttribute("libro", ldao.verUno(isbn));
		model.addAttribute("listaTemas", tdao.findAll());
		return "editar";
	}

	@PostMapping("/editar")
	public String procEditarLibro(Model model, Libro libro) {
		libro.setNovedad("s");
		ldao.modificarLibro(libro);
		return "redirect:/";
	}

	@GetMapping("/eliminar/{isbn}")
	public String procEliminar(Model model, @PathVariable("isbn") long isbn) {
		if (ldao.eliminarLibro(isbn) == 1)
			model.addAttribute("mensaje", "Libro eliminado");
		else
			model.addAttribute("mensaje", "Libro NOOO eliminado");
		return "forward:/";
	}

	@GetMapping("/alta")
	public String enviarFormulario(Model model) {
		model.addAttribute("listaTemas", tdao.findAll());
		return "formLibro";
	}

	@PostMapping("/alta")
	public String procAltaLibro(Model model, Libro libro) {
		libro.setImagen(null);
		libro.setNovedad("s");
		ldao.altaLibro(libro);
		return "redirect:/";
	}

	@GetMapping("/temas")
	public String procVerTemas(Model model) {
		model.addAttribute("listaTemas", tdao.findAll());
		return "listadoTemas";
	}

	@GetMapping("/perfiles")
	public String procVerPerfiles(Model model) {
		model.addAttribute("listaPerfiles", pdao.findAll());
		return "listadoPerfiles";
	}

	@GetMapping("/usuarios")
	public String procVerUsuarios(Model model) {
		model.addAttribute("listaUsuarios", udao.findAll());
		return "listadoUsuarios";
	}

}

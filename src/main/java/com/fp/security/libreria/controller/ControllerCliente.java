package com.fp.security.libreria.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fp.security.libreria.model.entityBeans.Libro;
import com.fp.security.libreria.model.entityBeans.LineasPedido;
import com.fp.security.libreria.model.entityBeans.Pedido;
import com.fp.security.libreria.model.entityBeans.Usuario;
import com.fp.security.libreria.modelo.dao.LibroDao;
import com.fp.security.libreria.modelo.dao.LineasPedidoDao;
import com.fp.security.libreria.modelo.dao.PedidoDao;
import com.fp.security.libreria.modelo.dao.UsuarioDao;

@Controller
@RequestMapping("/cliente")
public class ControllerCliente {

	@Autowired
	LibroDao ldao;
	
	@Autowired
	LineasPedidoDao lineasPedidoDao;
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@Autowired
	PedidoDao pedidoDao;
	
	List<Libro> carrito = new ArrayList<>();
	
	@GetMapping("/verDetalle/{isbn}")
	public String procDetalle(Model model, @PathVariable("isbn") long isbn) {
		model.addAttribute("listaLibros", ldao.verUno(isbn));
		return "verUnLibro";
	}
		
	@GetMapping("/addCarrito/{isbn}")
	public String alCarrito(@PathVariable("isbn") long isbn, Libro libro) {
		Libro libroEnCarrito = ldao.verUno(isbn);
		if (carrito.indexOf(libroEnCarrito) == -1)
			carrito.add(libroEnCarrito);
		return "forward:/"; // a lista novedades??
	}
	
	@GetMapping("/verCarrito")
	public String verCarrito(Model model, Authentication aut) {
		model.addAttribute("carrito", carrito);
		model.addAttribute("usuario", aut.getName());
		return "verCarrito";
	}
	
	@GetMapping("/volver")
	public String volver() {
		return "forward:/";
	}

	@GetMapping("/comprar")
	public String comprar(Authentication aut, Model model) {
		List<LineasPedido> lineasPedido = new ArrayList<>();
		Pedido pedido = new Pedido();
		Usuario usuario = usuarioDao.findById(aut.getName());
		pedido.setUsuario(usuario);
		pedido.setDireccionEntrega(usuario.getDireccion());
		pedido.setEstado("Terminado");
		pedidoDao.altaPedido(pedido);
		BigDecimal importePedido = new BigDecimal("0.00");
		
		for (int i = 0; i < carrito.size(); i++) {
			LineasPedido lineaPedido = new LineasPedido();
			Libro libro = carrito.get(i);
			lineaPedido.setLibro(libro);
			lineaPedido.setCantidad(1);
			lineaPedido.setPedido(pedido);
			lineaPedido.setPrecioVenta(libro.getPrecioUnitario());
			lineasPedidoDao.altaLineaPedido(lineaPedido);
			lineasPedido.add(lineaPedido);
			importePedido = lineaPedido.getPrecioVenta();
		}
		
		carrito.clear();
		model.addAttribute("lineasPedido", lineasPedido);
		model.addAttribute("importe", importePedido);

		return "pedidoFinalizado";
	}

	@GetMapping("/eliminar/{isbn}")
	public String eliminarLibro(@PathVariable("isbn") long isbn) {
		Libro libroEnCarrito = ldao.verUno(isbn);
		carrito.remove(libroEnCarrito);
		return "redirect:/cliente/verCarrito";	
	}
	
	@GetMapping("/busquedaPorTema")
	public String buscarPorTema(@RequestParam("nombreTema") String nombreTema, Model model) {
		List<Libro> librosPorTema = ldao.buscarLibroPorTema(nombreTema != null ? nombreTema.toLowerCase() : null);
		model.addAttribute("librosPorTema", librosPorTema);
		model.addAttribute("nombreTema", nombreTema);
		return "librosPorTema";
	}

	@GetMapping("/busquedaPorPalabra")
	public String buscarPorPalabra(@RequestParam("palabra") String palabra, Model model) {
		List<Libro> librosPorPalabra = ldao.buscarLibroPorPalabra(palabra != null ? palabra.toLowerCase() : null);
		model.addAttribute("librosPorPalabra", librosPorPalabra);
		model.addAttribute("palabra", palabra);
		return "librosPorPalabra";
	}

}

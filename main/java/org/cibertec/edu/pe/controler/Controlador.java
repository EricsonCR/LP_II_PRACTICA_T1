package org.cibertec.edu.pe.controler;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfacesServices.IProductoService;
import org.cibertec.edu.pe.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class Controlador {

	@Autowired
	private IProductoService service;

	@GetMapping("/listar")
	public String Listar(Model modelo) {
		List<Producto> productos = service.Listar();
		modelo.addAttribute("productos", productos);
		return "index";
	}

	@GetMapping("/agregar")
	public String Agregar(Model modelo) {
		modelo.addAttribute("producto", new Producto());
		return "agregar";
	}

	@PostMapping("/guardar")
	public String Guardar(@Validated Producto p, Model modelo) {
		service.Guardar(p);
		return "redirect:/listar";
	}

	@GetMapping("/editar/{id}")
	public String Editar(@PathVariable int id, Model modelo) {
		Optional<Producto> producto = service.Buscar(id);
		modelo.addAttribute("producto", producto);
		return "editar";
	}

	@GetMapping("/detalle/{id}")
	public String Detalle(@PathVariable int id, Model modelo) {
		Optional<Producto> producto = service.Buscar(id);
		modelo.addAttribute("producto", producto);
		return "detalle";
	}

	@GetMapping("/eliminar/{id}")
	public String Eliminar(Model modelo, @PathVariable int id) {
		service.Eliminar(id);
		return "redirect:/listar";
	}
}

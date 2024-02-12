package org.cibertec.edu.pe.service;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfaces.IProducto;
import org.cibertec.edu.pe.interfacesServices.IProductoService;
import org.cibertec.edu.pe.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

	@Autowired
	private IProducto data;

	@Override
	public List<Producto> Listar() {
		return (List<Producto>) data.findAll();
	}

	@Override
	public Optional<Producto> Buscar(int id) {
		return data.findById(id);
	}

	@Override
	public int Guardar(Producto p) {
		int r = 0;
		Producto producto = data.save(p);
		if (!producto.equals(null)) {
			r = 1;
		}
		return r;
	}

	@Override
	public void Eliminar(int id) {
		data.deleteById(id);
	}

}

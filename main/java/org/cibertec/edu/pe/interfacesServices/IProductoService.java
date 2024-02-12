package org.cibertec.edu.pe.interfacesServices;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.modelo.Producto;

public interface IProductoService {
	public List<Producto> Listar();

	public Optional<Producto> Buscar(int id);

	public int Guardar(Producto p);

	public void Eliminar(int id);
}

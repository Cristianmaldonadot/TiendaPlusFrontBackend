package com.tiendaplus.interfacesServices;

import java.util.List;

import com.tiendaplus.model.Producto;
import com.tiendaplus.model.Usuario;

public interface IProductoService {
	
	public Producto registrarProducto(Producto pro);
	public List<Producto> listar();
	public List<Producto> listarPorUsuario(Usuario usuario);
	public Producto obtenerProductoById(Long id);

}

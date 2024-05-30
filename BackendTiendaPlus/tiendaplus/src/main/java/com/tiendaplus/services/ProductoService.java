package com.tiendaplus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendaplus.interfaces.IProducto;
import com.tiendaplus.interfacesServices.IProductoService;
import com.tiendaplus.model.Producto;
import com.tiendaplus.model.Usuario;

@Service
public class ProductoService implements IProductoService {

	@Autowired
	private IProducto dataProducto;
	
	@Override
	public Producto registrarProducto(Producto pro) {
		return dataProducto.save(pro);
	}

	@Override
	public List<Producto> listar() {
		return (List<Producto>) dataProducto.findAll();
	}

	@Override
	public List<Producto> listarPorUsuario(Usuario usuario) {
		return dataProducto.findByUsuario(usuario);
	}

	@Override
	public Producto obtenerProductoById(Long id) {
		Optional<Producto> producto = dataProducto.findById(id);
		return producto.orElse(null);
	}

	
	
	
}

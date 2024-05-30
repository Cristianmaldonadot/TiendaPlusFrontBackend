package com.tiendaplus.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tiendaplus.model.Producto;
import com.tiendaplus.model.Usuario;

@Repository
public interface IProducto extends CrudRepository<Producto, Long> {
	
	List<Producto> findByUsuario(Usuario usuario);
}

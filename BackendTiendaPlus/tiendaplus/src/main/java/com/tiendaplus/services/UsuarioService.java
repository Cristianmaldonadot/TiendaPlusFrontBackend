package com.tiendaplus.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendaplus.interfaces.IUsuario;
import com.tiendaplus.interfacesServices.IUsuarioService;
import com.tiendaplus.model.Usuario;

@Service
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	private IUsuario dataUsuario;

	@Override
	public Usuario registrarUsuario(Usuario usu) {
		return dataUsuario.save(usu);
	}

	@Override
	public Usuario obtenerUsuarioPorId(Long id) {
		Optional<Usuario> optionalUsuario = dataUsuario.findById(id);
		return optionalUsuario.orElse(null);
	}

	@Override
	public Usuario findByUsername(String username) {
		return dataUsuario.findByUsername(username).orElse(null);
	}

	

	/*
	 * @Override public Usuario obtenerUsuarioPorUsername(String username) {
	 * Optional<Usuario> optionalUsuario = dataUsuario.findByUsername(username);
	 * return optionalUsuario.orElse(null); }
	 */

}

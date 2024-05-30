package com.tiendaplus.interfacesServices;

import com.tiendaplus.model.Usuario;

public interface IUsuarioService {
	
	public Usuario registrarUsuario(Usuario usu);
	public Usuario obtenerUsuarioPorId(Long id);
	public Usuario findByUsername(String username);

}

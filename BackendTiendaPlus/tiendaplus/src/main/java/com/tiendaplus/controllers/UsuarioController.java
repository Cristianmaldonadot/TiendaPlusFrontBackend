package com.tiendaplus.controllers;

import java.io.IOException;
import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tiendaplus.controllers.request.CreateUserDTO;
import com.tiendaplus.controllers.request.DireccionDTO;
import com.tiendaplus.interfaces.IDireccionEntity;
import com.tiendaplus.interfaces.IUsuario;
import com.tiendaplus.interfacesServices.IS3Service;
import com.tiendaplus.model.Avatar;
import com.tiendaplus.model.DireccionEntity;
import com.tiendaplus.model.ERole;
import com.tiendaplus.model.RolEntity;
import com.tiendaplus.model.Usuario;
import com.tiendaplus.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
public class UsuarioController {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private IUsuario userRepository;
	
	@Autowired
	private IDireccionEntity direccionEntity;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired 
	private IS3Service is3Service;
	
	/*
	 * @PostMapping("/registrarusuario") public Usuario
	 * registrarUsuario(@RequestParam String email, @RequestParam String
	 * username, @RequestParam String password) {
	 * 
	 * Usuario usuario = new Usuario(null, email, username, password);
	 * 
	 * return usuarioService.registrarUsuario(usuario); }
	 */
	
	@PostMapping("/registrarusuario")
	public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO createUserDTO){
		
		Set<RolEntity> roles = createUserDTO.getRoles().stream()
				.map(role -> RolEntity.builder()
						.name(ERole.valueOf(role))
						.build())
				.collect(Collectors.toSet());
		
		/*List<DireccionEntity> direcciones = createUserDTO.getDirecciones().stream()
				.map(direccion -> DireccionEntity.builder()
						.nombre(direccion)
						.build())
				.collect(Collectors.toList());*/
		
		Usuario userEntity = Usuario.builder()
				.username(createUserDTO.getUsername())
				.docidentidad(createUserDTO.getDocidentidad())
				.celular(createUserDTO.getCelular())
				.password(encoder.encode(createUserDTO.getPassword()))
				.email(createUserDTO.getEmail())
				.roles(roles)
				//.direcciones(direcciones)
				.build();
		
		userRepository.save(userEntity);
		
		return ResponseEntity.ok(userEntity);
					
	}
	
	@GetMapping("/usuariopornombre/{nombre}")
	public Optional<Usuario> obtenerUsuarioNombre(@PathVariable String nombre) {
		Optional<Usuario> usuario = userRepository.findByUsername(nombre);
		return usuario;
	}
	
	@PostMapping("/actualizarusuario/{id}")
	public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario nuevoUsuario){
		Optional<Usuario> optionalUsuario = userRepository.findById(id);

        if (optionalUsuario.isPresent()) {
            Usuario usuarioExistente = optionalUsuario.get();

            // Actualizar propiedades según sea necesario
            usuarioExistente.setDocidentidad(nuevoUsuario.getDocidentidad());
            usuarioExistente.setCelular(nuevoUsuario.getCelular());
            usuarioExistente.setEmail(nuevoUsuario.getEmail());
            usuarioExistente.setNombre(nuevoUsuario.getNombre());
            usuarioExistente.setAppaterno(nuevoUsuario.getAppaterno());
            usuarioExistente.setApmaterno(nuevoUsuario.getApmaterno());
            // Puedes actualizar más propiedades según sea necesario

            // Guardar el usuario actualizado en la base de datos
            Usuario usuarioActualizado = userRepository.save(usuarioExistente);

            return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
	
	@PostMapping("/agregardireccionusuario/{id}")
	public ResponseEntity<Usuario> agregarDireccion(@PathVariable Long id, @RequestBody String[] nuevaDireccion){
		
		String nombreDireccion = nuevaDireccion[0];
		
		Optional<Usuario> optionalUsuario = userRepository.findById(id);

	    if (optionalUsuario.isPresent()) {
	        Usuario usuarioExistente = optionalUsuario.get();

	        // Paso 2: Obtener la lista actual de direcciones del usuario
	        List<DireccionEntity> direccionesActuales = usuarioExistente.getDirecciones();
	        System.out.println("Estas son las direcciones "+direccionesActuales);

	        // Paso 3: Agregar la nueva dirección a la lista
	        DireccionEntity nuevaDireccionEntity = DireccionEntity.builder()
	                .nombre(nombreDireccion)
	                .build();
	        direccionesActuales.add(nuevaDireccionEntity);

	        // Paso 4: Actualizar la lista de direcciones del usuario
	        usuarioExistente.setDirecciones(direccionesActuales);
	        
	        direccionEntity.delete(direccionesActuales.get(0));
	        // Paso 5: Guardar el usuario actualizado en la base de datos
	        userRepository.save(usuarioExistente);
	        
	        return ResponseEntity.ok(usuarioExistente);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@DeleteMapping("/{idUsuario}/eliminardireccion/{idDireccion}")
    public ResponseEntity<?> eliminarDireccion(@PathVariable Long idUsuario, @PathVariable Long idDireccion) {
        Optional<Usuario> optionalUsuario = userRepository.findById(idUsuario);
        
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();

            // Buscar la dirección en la lista de direcciones del usuario
            Optional<DireccionEntity> optionalDireccion = usuario.getDirecciones().stream()
                    .filter(direccion -> direccion.getId().equals(idDireccion))
                    .findFirst();

            if (optionalDireccion.isPresent()) {
                DireccionEntity direccion = optionalDireccion.get();

                // Eliminar la dirección de la lista del usuario
                usuario.getDirecciones().remove(direccion);

                // Eliminar la dirección de la base de datos
                direccionEntity.delete(direccion);

                // Guardar el usuario actualizado
                userRepository.save(usuario);

                return ResponseEntity.ok("Dirección eliminada correctamente");
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@PostMapping("/{idUsuario}/cambiarcontrasena/{contraOld}/{contraNew}")
	public ResponseEntity<?> cambiarContraseña(@PathVariable Long idUsuario, @PathVariable String contraOld, @PathVariable String contraNew){
		//String contraAntigua =  passwordEncoder.encode(contraOld);
		String contraNueva = passwordEncoder.encode(contraNew);
		
		Optional<Usuario> optionalUsuario = userRepository.findById(idUsuario);
		
		if (optionalUsuario.isPresent()) {
			
			Usuario usuario = optionalUsuario.get();
			String contraUsuario = usuario.getPassword();
			
			System.out.println(contraUsuario + "|||||" +  contraOld + "|||||" + contraNueva );
			
			boolean coincide = passwordEncoder.matches(contraOld, contraUsuario);
			
			if(coincide == true) {
				
				usuario.setPassword(contraNueva);
				
				userRepository.save(usuario);
				
				return ResponseEntity.ok("Contraseña actualizada correctamente");
			}else {
                return ResponseEntity.notFound().build();
            }
		} else {
            return ResponseEntity.notFound().build();
        }
	}
	
	@PostMapping("/agregar/{idUsuario}")
	public ResponseEntity<?> agregarAvatar(@PathVariable Long idUsuario, @RequestParam ("avatar") int avatar) throws IOException{
		
		
		Optional<Usuario> optionalUsuario = userRepository.findById(idUsuario);
		if (optionalUsuario.isPresent()) {
			
			Usuario usuario = optionalUsuario.get();
			
			List<Avatar> nuevaListaAvatar = new ArrayList<>();
			
			Avatar nuevoAvatar = Avatar.builder()
					.imagen(avatar)
					.build();
			
			nuevaListaAvatar.add(nuevoAvatar);
			
			usuario.setAvatares(nuevaListaAvatar);
			
			userRepository.save(usuario);
			return ResponseEntity.ok("Avatar Guardado correctamente");
			}else {
				return ResponseEntity.notFound().build();
			}
	}
//	@PostMapping("/agregar/{idUsuario}")
//	public ResponseEntity<?> agregarAvatar(@PathVariable Long idUsuario, @RequestParam ("avatar") MultipartFile avatar) throws IOException{
//		
//		
//		Optional<Usuario> optionalUsuario = userRepository.findById(idUsuario);
//		if (optionalUsuario.isPresent()) {
//			
//			Usuario usuario = optionalUsuario.get();
//					
//			String urlCompleta;
//			String nombreArchivo = avatar.getOriginalFilename();
//			urlCompleta = "http://imagenes-tienda.s3.us-east-2.amazonaws.com/" + nombreArchivo;
//			is3Service.uploadFile(avatar);
//			
//			List<Avatar> nuevaListaAvatar = usuario.getAvatares();
//			
//			Avatar nuevoAvatar = Avatar.builder()
//					.imagen(urlCompleta)
//					.build();
//			
//			nuevaListaAvatar.add(nuevoAvatar);
//			
//			usuario.setAvatares(nuevaListaAvatar);
//			
//			userRepository.save(usuario);
//			return ResponseEntity.ok("Avatar Guardado correctamente");
//			}else {
//				return ResponseEntity.notFound().build();
//			}
//	}


}

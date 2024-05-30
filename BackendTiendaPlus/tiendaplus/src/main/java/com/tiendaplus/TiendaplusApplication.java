package com.tiendaplus;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tiendaplus.interfaces.IUsuario;
import com.tiendaplus.model.ERole;
import com.tiendaplus.model.RolEntity;
import com.tiendaplus.model.Usuario;

@SpringBootApplication
public class TiendaplusApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaplusApplication.class, args);
	}
	/*
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	IUsuario userRepository;
	
	
	@Bean
	CommandLineRunner init() {
		return args -> {
				
			Usuario userEntity = Usuario.builder()
					.email("cristhiandesing@gmail.com")
					.username("cristian")
					.password(passwordEncoder.encode("123456"))
					.roles(Set.of(RolEntity.builder()
							.name(ERole.valueOf(ERole.ADMIN.name()))
							.build()))
					.build();
			
			Usuario userEntity2 = Usuario.builder()
					.email("ethanmaldonado@gmail.com")
					.username("ethan")
					.password(passwordEncoder.encode("123456"))
					.roles(Set.of(RolEntity.builder()
							.name(ERole.valueOf(ERole.RECEP.name()))
							.build()))
					.build();
			
			Usuario userEntity3 = Usuario.builder()
					.email("candysalinas@gmail.com")
					.username("candy")
					.password(passwordEncoder.encode("123456"))
					.roles(Set.of(RolEntity.builder()
							.name(ERole.valueOf(ERole.CAJERA.name()))
							.build()))
					.build();
			
			userRepository.save(userEntity);
			userRepository.save(userEntity2);
			userRepository.save(userEntity3);
		};
				
			
		}
		
		
		
	
*/
}

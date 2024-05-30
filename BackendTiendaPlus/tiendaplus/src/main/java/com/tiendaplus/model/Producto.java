package com.tiendaplus.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "random-id")
    @GenericGenerator(name = "random-id", strategy = "com.tiendaplus.RandomIdGenerator")
	private Long idproducto;
	private String marca;
	private String nombre;
	private String descripcion;
	private int stock;
	private String imagen;
	private String categoria;
	private double precio;
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;

}

package com.tiendaplus.controllers.request;

import org.springframework.web.multipart.MultipartFile;

import com.tiendaplus.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoRequest {
    private Long idproducto;
    private String marca;
    private String nombre;
    private String descripcion;
    private int stock;
    private String categoria;
    private double precio;
    private Usuario usuario;
    private MultipartFile file;

}
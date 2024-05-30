package com.tiendaplus.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tiendaplus.interfacesServices.IS3Service;
import com.tiendaplus.model.Producto;
import com.tiendaplus.model.Usuario;
import com.tiendaplus.services.ProductoService;
import com.tiendaplus.services.S3Service;
import com.tiendaplus.services.UsuarioService;

@RestController
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired 
	private IS3Service is3Service;
	
	@GetMapping("/hello")
	public String hola() {
		return "Hello World Not Security";
	}
	
	@PostMapping("/registrarproducto")
	public String registrarproducto(@RequestParam Long idproducto, @RequestParam String marca, @RequestParam String nombre, @RequestParam String descripcion, @RequestParam int stock,
			@RequestParam String categoria, @RequestParam double precio, @RequestParam Usuario usuario, @RequestParam(value = "file", required = false) MultipartFile file, String oldnamefile) throws IOException {
		
		String urlCompleta;
		if (file == null ) {
			urlCompleta = "http://imagenes-tienda.s3.us-east-2.amazonaws.com/" + oldnamefile;
			System.out.println("LLeguea aca 1");
		}else {
			System.out.println("LLeguea aca 2");
			String nombreArchivo = file.getOriginalFilename();
			urlCompleta = "http://imagenes-tienda.s3.us-east-2.amazonaws.com/" + nombreArchivo;
			is3Service.uploadFile(file);
			is3Service.deleteFile(oldnamefile);
		}
		
		Producto producto = new Producto(idproducto, marca, nombre, descripcion, stock, urlCompleta, categoria, precio, usuario);
		System.out.println(oldnamefile);
		System.out.println("Este es el producto"+producto);
		
		productoService.registrarProducto(producto);
		return "Producto Registrado";
	}
	
	@GetMapping("/listarproductosporid")
	public List<Producto> listarporid(@RequestParam("idusuario") Long idusuario ){
		System.out.println("estoy listando");
		Usuario usuario = usuarioService.obtenerUsuarioPorId(idusuario);
		
		return productoService.listarPorUsuario(usuario);
	}
	
	@GetMapping("/listarproductos")
	public List<Producto> listar(){
		return productoService.listar();
	}
	
	@GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Long id) {
        Producto producto = productoService.obtenerProductoById(id);

        // Verificar si el nombre en la URL coincide con el nombre del producto
        if (!id.equals(producto.getIdproducto())) {
            // Manejar error o redireccionar a la URL correcta
            return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
                    .header(HttpHeaders.LOCATION, "/productos/" + id)
                    .build();
        }

        return ResponseEntity.ok().body(producto);
    }
	
	@DeleteMapping("/delete/{fileName}")
	public String deleteFile(@PathVariable("fileName") String fileName) throws IOException {
		return is3Service.deleteFile(fileName);
	}
	
	/*@PostMapping("/registrarproducto")
	public String registrarproducto(@Validated @RequestBody Producto pro) {
		
		productoService.registrarProducto(pro);
		return "Producto Registrado";
	}*/
	
	/*@PostMapping("/subirimagen")
	public String subirImagenes(@RequestParam("file") MultipartFile file) throws IOException {
		return is3Service.uploadFile(file);
	}*/
	
}

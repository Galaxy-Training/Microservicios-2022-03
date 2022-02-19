package pe.edu.galaxy.training.java.sb.msproductos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.galaxy.training.java.sb.msproductos.entity.Producto;
import pe.edu.galaxy.training.java.sb.msproductos.service.IProductoService;

@RestController
public class ProductoController {

	@Value("${server.port}")
	private Integer port;
	
	
	// Inyección de Dependencias
	
	@Autowired
	private IProductoService productoService;
	
	
	@GetMapping("/listar")
	public List<Producto> listar(){

		return productoService.findAll().stream().map(producto ->{
			producto.setPort(port);
			return producto;	
		}).collect(Collectors.toList());	
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto producto = productoService.findById(id);
		producto.setPort(port);
		
		return producto;
		
	}
	
	
}

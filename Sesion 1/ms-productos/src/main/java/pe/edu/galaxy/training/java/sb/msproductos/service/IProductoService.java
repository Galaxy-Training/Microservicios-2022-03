package pe.edu.galaxy.training.java.sb.msproductos.service;

import java.util.List;

import pe.edu.galaxy.training.java.sb.msproductos.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	
	public Producto findById(Long id);
	
	
}

package pe.edu.galaxy.training.java.sb.msproductos.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.galaxy.training.java.sb.msproductos.dao.ProductoDao;
import pe.edu.galaxy.training.java.sb.msproductos.entity.Producto;


@Service
public class ProductoServiceImpl implements IProductoService {
	
	// Inyecccion de dependencias
	
	@Autowired
	private ProductoDao productoDao;

	@Override
	@Transactional(readOnly= true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
	
		return productoDao.findById(id).orElse(null);
	}

}

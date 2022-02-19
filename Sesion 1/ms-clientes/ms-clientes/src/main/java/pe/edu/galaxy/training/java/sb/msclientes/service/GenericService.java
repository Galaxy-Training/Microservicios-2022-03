package pe.edu.galaxy.training.java.sb.msclientes.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;

public interface GenericService<T> {
	
	List<T> list(T t) throws  ServiceException;
	
	Optional<T> findById(T t ) throws  ServiceException;
	
	T save(T t) throws  ServiceException;
	
	

}

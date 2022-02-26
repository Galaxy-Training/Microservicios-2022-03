package pe.edu.pe.galaxy.training.java.sb.ms.gestion.instructores.service.generic;

import java.util.List;
import java.util.Optional;

import pe.edu.pe.galaxy.training.java.sb.ms.gestion.instructores.service.excepcion.ServiceException;



public interface GenericService<T> {

	
	List<T> list(T t) throws ServiceException;
	
	Optional<T> findById (T t) throws ServiceException;
	
	
	T save(T t) throws ServiceException;
	
	
	
	
	
	
}
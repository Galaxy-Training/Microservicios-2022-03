package pe.edu.galaxy.training.java.sb.ms.gestion.taller.service.generic;

import java.util.List;
import java.util.Optional;

import pe.edu.galaxy.training.java.sb.ms.gestion.taller.service.exception.ServiceException;

public interface GenericService<T> {
	
	List<T> list(T t) throws ServiceException;
	
	Optional<T> findById(T t) throws ServiceException;
	
	T save(T t) throws ServiceException;
	
}

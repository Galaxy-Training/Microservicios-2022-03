package pe.edu.pe.galaxy.training.java.sb.ms.gestion.instructores.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.edu.pe.galaxy.training.java.sb.ms.gestion.instructores.entity.InstructorEntity;
import pe.edu.pe.galaxy.training.java.sb.ms.gestion.instructores.repository.generic.GenericRepository;

public interface InstructorRepository extends GenericRepository<InstructorEntity, Long> {

	
	@Query("select p from InstructorEntity p where p.estado='1'")
	List<InstructorEntity> findAllCustom();
	

}

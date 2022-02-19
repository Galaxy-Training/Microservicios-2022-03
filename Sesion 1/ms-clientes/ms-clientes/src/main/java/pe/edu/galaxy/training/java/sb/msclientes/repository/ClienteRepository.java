package pe.edu.galaxy.training.java.sb.msclientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.galaxy.training.java.sb.msclientes.entity.ClienteEntity;

public interface ClienteRepository extends GenericRepository<ClienteEntity, Long> {

	// JPQ
	
	@Query("select p from ClienteEntity p where upper(p.razonSocial) "
			+ " like: razonSocial and p.estado= '1'")
	
	List<ClienteEntity> list(@Param("razonSocial") String razonSocial);
	
			
			
		
}

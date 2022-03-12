package pe.edu.galaxy.training.java.sb.ms.gestion.taller.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.entity.TallerEntity;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.repository.generic.GenericRepository;

@Repository
public interface TallerRepository extends GenericRepository<TallerEntity, Long>{
	
	@Query("select p from TallerEntity p where p.estado='1'")	
	List<TallerEntity> findAllCustom();
	

}

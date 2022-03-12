package pe.edu.galaxy.training.java.sb.ms.gestion.taller.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.entity.TallerSituacionEntity;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.repository.generic.GenericRepository;

@Repository
public interface TallerSituacionRepository extends GenericRepository<TallerSituacionEntity, Long>{
	
	@Query("select p from TallerSituacionEntity p where p.estado='1'")
	List<TallerSituacionEntity> findAllCustom();
	

}

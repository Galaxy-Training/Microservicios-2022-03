package pe.edu.galaxy.training.java.sb.ms.gestion.taller.service.taller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.TallerSituacionDTO;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.repository.TallerSituacionRepository;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.service.exception.ServiceException;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.service.taller.srv.TallerSituacionService;

@Slf4j
@Service
public class TallerSituacionServiceImpl implements TallerSituacionService{
	

	@Autowired
	private TallerSituacionRepository tipoDocumentoRepository; //IoC/DI
	
	@Override
	public List<TallerSituacionDTO> list(TallerSituacionDTO t) throws ServiceException {
		try {
			
			List<TallerSituacionDTO> lstTallerSituacionDTO=new ArrayList<>();
			
			 tipoDocumentoRepository.findAllCustom().forEach(tdDTO -> {
				 lstTallerSituacionDTO.add(
						 TallerSituacionDTO
						 .builder()
						 .id(tdDTO.getId())
						 .nombre(tdDTO.getNombre())
						 .build());
			 });
			 
			 return lstTallerSituacionDTO;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), t);
			throw new ServiceException(e);
		}
	}

	@Override
	public Optional<TallerSituacionDTO> findById(TallerSituacionDTO t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TallerSituacionDTO save(TallerSituacionDTO t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	
}

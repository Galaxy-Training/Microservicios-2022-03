package pe.edu.galaxy.training.java.sb.ms.gestion.taller.service.taller.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.TallerDTO;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.client.InstructorDTO;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.entity.TallerEntity;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.repository.TallerRepository;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.service.client.InstructorClient;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.service.client.InstructorClientTemplate;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.service.exception.ServiceException;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.service.taller.srv.TallerService;

@Service
public class TallerServiceImpl implements TallerService{

	@Autowired
	private TallerRepository tallerRepository;
	
	@Autowired
	private InstructorClientTemplate  instructorClientTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<TallerDTO> list(TallerDTO t) throws ServiceException {
		try {
			return tallerRepository.findAllCustom().stream()
								.map(e-> this.getTallerDTO(e))
								.collect(Collectors.toList());	
					
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public TallerDTO save(TallerDTO tallerDTO) throws ServiceException {
		try {
			
			TallerEntity prmTallerEntity = this.getTallerEntity(tallerDTO);
			
			TallerEntity retTallerEntity = tallerRepository.save(prmTallerEntity);
				
			return this.getTallerDTO(retTallerEntity);
			
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Optional<TallerDTO> findById(TallerDTO tallerDTO) throws ServiceException {
		try {
			Optional<TallerEntity> optTallerEntity=  tallerRepository.findById(tallerDTO.getId());
			if (!optTallerEntity.isEmpty() && optTallerEntity.isPresent()) {
				
				// Integracion
				
				InstructorDTO intructorDTO = instructorClientTemplate.findById(tallerDTO.getId());
				
				TallerDTO oTallerDTO = this.getTallerDTO(optTallerEntity.get());
				oTallerDTO.setInstructor(intructorDTO);
				
				return Optional.of(oTallerDTO);
				
				
			}
			return Optional.of(null);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	
	

	// Mappers
	private TallerEntity getTallerEntity(TallerDTO tallerDTO) {
		return objectMapper.convertValue(tallerDTO, TallerEntity.class);
	}
	
	private TallerDTO getTallerDTO(TallerEntity tallerEntity) {
		return objectMapper.convertValue(tallerEntity, TallerDTO.class);
	}

}

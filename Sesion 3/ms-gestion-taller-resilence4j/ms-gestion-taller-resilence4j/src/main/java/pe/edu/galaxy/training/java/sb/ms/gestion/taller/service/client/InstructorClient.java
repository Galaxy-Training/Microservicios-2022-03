package pe.edu.galaxy.training.java.sb.ms.gestion.taller.service.client;

import pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.client.InstructorDTO;
import reactor.core.publisher.Mono;

public interface InstructorClient {

	Mono<InstructorDTO> findById(Long id) throws ClientException;
}

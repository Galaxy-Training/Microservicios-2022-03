package pe.edu.galaxy.training.java.sb.ms.gestion.taller.service.client;


import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.controller.commons.ObjectResponse;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.client.InstructorDTO;

@Slf4j
@Component
public class InstructorClientTemplateImpl implements InstructorClientTemplate{
	
	
	private CircuitBreaker circuitBreaker;

	//private DiscoveryClient discoveryClient;

	// Client
	private RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private String uri="http://localhost:8084";
	
	public InstructorClientTemplateImpl(CircuitBreakerFactory<?,?> circuitBreakerFactory, RestTemplate restTemplate) {
		
		this.restTemplate=restTemplate;
		
		this.circuitBreaker = circuitBreakerFactory.create("instructores");

	}

	@Override
	public InstructorDTO findById(Long id) throws ClientException {
		
		/*
		if (Objects.isNull(restTemplate)) {
			log.info("restTemplate is null");
		}else {
			log.info("restTemplate is not null");
		}*/

		return circuitBreaker.run(() -> {
			ObjectResponse objectResponse = restTemplate.getForObject(this.uri + "/instructores/" + id, ObjectResponse.class);
			
			return objectMapper.convertValue(objectResponse.getData(), InstructorDTO.class);
		},
				// Error
				throwable -> this.getInstructorDTO());

	}
	
	// Plan B
	private InstructorDTO getInstructorDTO() {
		
		return InstructorDTO.builder().id(0L).apellidoPaterno("AP").apellidoMaterno("AM").nombres("Nombre").build();
		
	}
}



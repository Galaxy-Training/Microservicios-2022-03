package pe.edu.galaxy.training.java.sb.ms.gestion.taller.service.client;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.controller.commons.ObjectResponse;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.TallerDTO;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.client.InstructorDTO;
import reactor.core.publisher.Mono;

//@Component
public class InstructorClientImpl implements InstructorClient{
	
	
	private WebClient webClient;
	
	private String uri="http://localhost:8084/instructores"; // ms-gestion-instructor ( Service Discovery)
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public InstructorClientImpl(WebClient.Builder webClient) {
		this.webClient=webClient.baseUrl(this.uri).build();

	}

	@Override
	public Mono<InstructorDTO> findById(Long id) throws ClientException {
		Mono<ObjectResponse> objectResponse=webClient.get().uri("/{id}", id).retrieve().bodyToMono(ObjectResponse.class);
		if (!Objects.isNull(objectResponse)) {
			
			/*
			 // Usando Gson - Google
			Gson gson= new Gson();
			InstructorDTO instructorDTO = gson.fromJson(gson.toJson(objectResponse.block().getData()), InstructorDTO.class);
			*/
			
			// Usando ObjectMapper
			
			InstructorDTO instructorDTO =  objectMapper.convertValue(objectResponse.block().getData(), InstructorDTO.class);
			
			
			Mono<InstructorDTO>  monoInstructor=Mono.just(instructorDTO);
			return monoInstructor;
		}
		return Mono.empty();
	}
	

}



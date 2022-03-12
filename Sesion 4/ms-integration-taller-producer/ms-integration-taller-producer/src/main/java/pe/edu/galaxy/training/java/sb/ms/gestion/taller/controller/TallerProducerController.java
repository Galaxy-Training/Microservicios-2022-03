package pe.edu.galaxy.training.java.sb.ms.gestion.taller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.TallerDTO;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.producer.TallerProducer;

@Slf4j
@RestController
@RequestMapping("/talleres-producer")
public class TallerProducerController {

	@Autowired
	private  TallerProducer tallerProducer;

	@PostMapping
	public ResponseEntity<Void> sendMessage(@RequestBody TallerDTO tallerDTO) {
		try {
			
			tallerProducer.sendMessage(tallerDTO);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}

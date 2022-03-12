package pe.edu.galaxy.training.java.sb.ms.gestion.taller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.controller.generic.GenericController;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.TallerSituacionDTO;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.service.taller.srv.TallerSituacionService;

@RestController
@RequestMapping("/taller-situaciones")
public class TallerSituacionController extends GenericController{
	
	@Autowired
	private TallerSituacionService tallerSituacionService;
	
	@GetMapping
	public ResponseEntity<List<TallerSituacionDTO>> findAll(){
		try {
			List<TallerSituacionDTO> lst= tallerSituacionService.list(null);
			return ResponseEntity.ok(lst);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}

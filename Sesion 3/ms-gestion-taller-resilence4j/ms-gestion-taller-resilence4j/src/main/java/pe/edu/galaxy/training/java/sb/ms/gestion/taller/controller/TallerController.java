package pe.edu.galaxy.training.java.sb.ms.gestion.taller.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.controller.commons.ObjectResponse;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.controller.enums.CRUDEnum;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.controller.generic.GenericController;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.TallerDTO;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.service.exception.ServiceException;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.service.taller.srv.TallerService;

@Slf4j
@RestController
@RequestMapping("/talleres")
public class TallerController extends GenericController {

	@Autowired
	private TallerService instructorService;

	@GetMapping
	public ResponseEntity<ObjectResponse> findAll() {
		try {

			List<TallerDTO> lst = instructorService.list(null);
			if (lst.isEmpty()) {	
				return super.notFound();
			}
			return super.ok(lst, CRUDEnum.CONSULTA);
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
			return super.error(e);

		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<ObjectResponse> findById(@PathVariable Long id) {
		try {
			if (id <= 0) {
				return super.badRequest("Id no válido, debe ser mayor que cero");
			}
			Optional<TallerDTO> opt = instructorService.findById(this.getTallerDTO(id));
			if (opt.isEmpty() || !opt.isPresent()) {
				return super.notFound(id);
			}
			return super.ok(opt.get(), CRUDEnum.CONSULTA);

		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
			return super.error(e);
		}
	}

	@PostMapping
	public ResponseEntity<ObjectResponse> post(@RequestBody @Validated TallerDTO instructorDTO,	BindingResult result) {

		if (result.hasErrors()) {
			return super.badRequest(result);
		}

		try {
			TallerDTO resTallerDTO = instructorService.save(instructorDTO);
			if (resTallerDTO != null) {
				return super.ok(resTallerDTO, CRUDEnum.REGISTRO);
			}
			return super.badRequest("Eror al registrar el cliente");
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
			return super.customError("Eror al registrar el cliente");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<ObjectResponse> put(@PathVariable Long id, @RequestBody TallerDTO instructorDTO,
			BindingResult result) {

		if (result.hasErrors()) {
			return super.badRequest(result);
		}

		try {

			Optional<TallerDTO> optTallerDTO = instructorService.findById(this.getTallerDTO(id));

			if (!optTallerDTO.isEmpty()) {

				TallerDTO oTallerDTO = optTallerDTO.get();

				instructorDTO.setId(id);
				BeanUtils.copyProperties(instructorDTO, oTallerDTO);

				TallerDTO resTallerDTO = instructorService.save(oTallerDTO);

				if (resTallerDTO != null) {
					return super.ok(resTallerDTO, CRUDEnum.ACTUALIZACION);
				}
			}
			return null;
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
			return super.error(e);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ObjectResponse> delete(@PathVariable Long id) {

		try {
			Optional<TallerDTO> optTallerDTO = instructorService.findById(this.getTallerDTO(id));

			if (!optTallerDTO.isEmpty()) {
				TallerDTO oTallerDTO = optTallerDTO.get();
				oTallerDTO.setEstado("0");
				TallerDTO resTallerDTO = instructorService.save(oTallerDTO);
				if (resTallerDTO != null) {
					return super.ok(resTallerDTO, CRUDEnum.ELIMINACION);
				}
			}

			return null;
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
			return super.error(e);
		}
	}

	private TallerDTO getTallerDTO(Long id) {
		return TallerDTO.builder().id(id).build();
	}

}

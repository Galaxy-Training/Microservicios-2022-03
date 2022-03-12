package pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.client.InstructorDTO;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.generic.GenericDTO;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.entity.TallerSituacionEntity;

@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id", "apellidoPaterno","apellidoMaterno",
	"nombres", "sexo","tipoDocumento", "nroDocumento","correo","telefono","fechaIngreso" })
public class TallerDTO extends GenericDTO{

	private static final long serialVersionUID = 1L;

	private String nombre;
	
	private String descripcion;
	
	private Long idInstructor;

	private TallerSituacionEntity situacion;
	
	private InstructorDTO instructor;
	
}

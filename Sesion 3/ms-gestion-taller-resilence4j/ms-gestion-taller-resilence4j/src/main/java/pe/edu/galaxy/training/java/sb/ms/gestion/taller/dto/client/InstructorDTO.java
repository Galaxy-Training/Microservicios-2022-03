package pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.client;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.generic.GenericDTO;

@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id", "apellidoPaterno","apellidoMaterno",
	"nombres", "sexo","tipoDocumento", "nroDocumento","correo","telefono","fechaIngreso" })
public class InstructorDTO extends GenericDTO{

	private static final long serialVersionUID = 1L;

	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private String nombres;
	
	private String sexo;
	
	private String nroDocumento;
	
	private String correo;

	private String telefono;
	
	private String fechaIngreso;

}

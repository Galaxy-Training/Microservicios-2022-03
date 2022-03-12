package pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto;

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
@JsonPropertyOrder({"_id","tallerId", "tallerNombre","instructorId","instructorNombre"})
public class TallerDTO extends GenericDTO{

	private static final long serialVersionUID = 1L;
	
	private Long tallerId;
	
	private String tallerNombre;
		
	private Long instructorId;
	
	private String instructorNombre;
	
}

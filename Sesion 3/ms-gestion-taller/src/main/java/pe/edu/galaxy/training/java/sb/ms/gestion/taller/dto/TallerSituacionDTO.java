package pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.generic.GenericDTO;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class TallerSituacionDTO  extends GenericDTO{

	private static final long serialVersionUID = 1L;

	private String nombre;
	

}

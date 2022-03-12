package pe.edu.galaxy.training.java.sb.ms.gestion.taller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.entity.generic.GenericEntity;

@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "TALLER_SITUACION")
@Entity(name = "TallerSituacionEntity")
public class TallerSituacionEntity  extends GenericEntity{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_TALLER_SITUACION")
	protected Long id;

	@Column(name = "NOMBRE")
	private String nombre;
	
}


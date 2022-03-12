package pe.edu.galaxy.training.java.sb.ms.gestion.taller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.entity.generic.GenericEntity;

@Data
@EqualsAndHashCode(callSuper=false)
@Builder
@Entity(name="TallerEntity")
@Table(name="TALLER")
@NoArgsConstructor
@AllArgsConstructor
public class TallerEntity extends GenericEntity{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TALLER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTaller")
	@SequenceGenerator(name = "seqTaller", allocationSize = 1, sequenceName = "SEQ_TALLER")
	@Builder.Default
	private Long id=0L;
	
	@Size(min=5, max=120, message="El nombre es requerido y debe ser mayor que {min} y máximo {max} caracteres")
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="ID_INSTRUCTOR")
	private Long idInstructor;

	@ManyToOne
	@JoinColumn(name="ID_TALLER_SITUACION", nullable=false)
	private TallerSituacionEntity situacion;
	
	/*FECHA_PROGRAMADA DATE  NULL,
	FECHA_REGISTRO DATE NULL,
	HORA_INICIO varchar2(10)  NULL,
	HORA_TERMINO varchar2(10)  NULL,
	DURACION NUMERIC(2,0)  NULL,
	*/	   
	// Temas
	
}


package pe.edu.pe.galaxy.training.java.sb.ms.gestion.instructores.entity;

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

import org.hibernate.annotations.JoinColumnOrFormula;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pe.edu.pe.galaxy.training.java.sb.ms.gestion.instructores.entity.generic.GenericEntity;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@Entity(name= "InstructorEntity")
@Table(name= "INSTRUCTOR")
@NoArgsConstructor
@AllArgsConstructor
public class InstructorEntity extends GenericEntity {

	@Id
	@Column(name="ID_INTRUCTOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqInstructor")
	@SequenceGenerator(name = "seqInstructor", allocationSize = 1, sequenceName = "SEQ_INSTRUCTOR")
    @Builder.Default
    private Long id=0L;
	
	
	
	@Size(min=5, max=60, message="El nombre es requerido y debe ser mayor que 5 y m�ximo 60 car�cteres")
	@Column(name="APELLIDO_PATERNO")
	private String apellidoPaterno;
	

	@Column(name="APELLIDO_MATERNO")
	private String apellidoMaterno;
	
	@Size(min=5, max=220, message="El nombre es requerido y debe ser mayor que 5 y m�ximo 220 car�cteres")
	@Column(name="NOMBRES", length = 60, nullable = false)
	private String nombres;
	
	@Size(min=1, max=1, message="El sexo es requerido y debe ser 'F' O 'T'")
	@Column(name="SEXO", length = 1, nullable = false)
	private String sexo;
	
	@Size(min=8, max=20, message="El nroDocumento es requerido y debe ser mayor que 8 y m�ximo 20 car�cteres")
	@Column(name="NRO_DOCUMENTO", length = 20, nullable = false)
	private String nroDocumento;
	
	
	@Size(min=8, max=20, message="El correo es requerido y debe ser mayor que 8 y m�ximo 20 car�cteres")
	@Column(name="CORREO", length = 20, nullable = false)
	private String correo;
	
	
	@Size(min=8, max=20, message="El telefono es requerido y debe ser mayor que 8 y m�ximo 20 car�cteres")
	@Column(name="TELEFONO", length = 20, nullable = false)
	private String telefono;
	
	@Size(min=8, max=20, message="La fecha de ingreso es requerida")
	@Column(name="FECHA_INGRESO", length = 20, nullable = false)
	private String fechaIngreso;
	
	
	@ManyToOne
	@JoinColumn(name="ID_TIPO_DOCUMENTO", nullable=false)
	private TipoDocumentoEntity tipoDocumento;
	
}

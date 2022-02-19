package pe.edu.galaxy.training.java.sb.msclientes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;



@Data
@EqualsAndHashCode (callSuper = false)
@Table(name = "CLIENTE")
@Entity (name = "ClienteEntity")
public class ClienteEntity extends GenericEntity {

	@Id
	@Column(name = "ID_CLIENTE")
	protected Long id;
	
	private String razonSocial;
	private String ruc;

}

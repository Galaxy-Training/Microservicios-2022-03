package pe.edu.galaxy.java.spring.boot.redis.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Taller implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String nombre;
	
	private String descripcion;
	
	private int duracion;	

}

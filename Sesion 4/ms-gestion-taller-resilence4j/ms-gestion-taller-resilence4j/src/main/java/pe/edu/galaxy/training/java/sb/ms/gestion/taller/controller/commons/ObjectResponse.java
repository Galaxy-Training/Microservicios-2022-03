package pe.edu.galaxy.training.java.sb.ms.gestion.taller.controller.commons;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObjectResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	private ObjectMessage	message;
	
	private Object  		data;
	
}

package pe.edu.galaxy.training.java.sb.ms.gestion.taller.consumer.client;

import pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.TallerDTO;

public interface TallerCommand {
	
	void enviar(TallerDTO tallerDTO);
}

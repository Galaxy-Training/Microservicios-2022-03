package pe.edu.galaxy.training.java.sb.ms.gestion.taller.producer;

import pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.TallerDTO;

public interface TallerProducer {

	public void sendMessage(TallerDTO tallerDTO);
}

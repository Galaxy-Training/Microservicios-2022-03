package pe.edu.galaxy.training.java.sb.ms.gestion.taller.consumer;

import pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.TallerDTO;

public interface TallerConsumer {

	public void consumeMessage(TallerDTO tallerDTO);
}

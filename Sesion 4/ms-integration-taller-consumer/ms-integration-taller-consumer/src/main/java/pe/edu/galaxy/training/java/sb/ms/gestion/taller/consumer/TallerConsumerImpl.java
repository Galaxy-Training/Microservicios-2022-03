package pe.edu.galaxy.training.java.sb.ms.gestion.taller.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.consumer.client.TallerCommand;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.TallerDTO;

@Slf4j
@Service
public class TallerConsumerImpl implements TallerConsumer{
	
	//@Autowired
	//private TallerCommand tallerCommand; 

	@KafkaListener(
			topics = "${custom.kafka.topic-name}",
			groupId = "${custom.kafka.group-id}",
			containerFactory = "tallerKafkaListenerContainerFactory")	
	@Override
	public void consumeMessage(TallerDTO tallerDTO) {
		log.info("Mensaje consumido [{}]", tallerDTO);
		//this.tallerCommand.enviar(tallerDTO);
			
	}
	
}

package pe.edu.galaxy.training.java.sb.ms.gestion.taller.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.TallerDTO;

@Slf4j
@Service
public class TallerProducerImpl implements TallerProducer{

	@Value("${custom.kafka.topic-name}")
	private String topicName;

	  @Autowired
	  private KafkaTemplate<String, TallerDTO> tallerKafkaTemplate;

	  public void sendMessage(TallerDTO tallerDTO) {
		  log.info("send taller",tallerDTO);
		  tallerKafkaTemplate.send(topicName, tallerDTO);
		  
	  }
}

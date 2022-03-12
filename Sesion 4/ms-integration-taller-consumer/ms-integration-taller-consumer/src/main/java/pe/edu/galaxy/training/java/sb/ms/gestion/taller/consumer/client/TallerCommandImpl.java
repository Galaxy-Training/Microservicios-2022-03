package pe.edu.galaxy.training.java.sb.ms.gestion.taller.consumer.client;

import java.util.List;
import java.util.Objects;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.gestion.taller.dto.TallerDTO;

@Slf4j
@Component
public class TallerCommandImpl implements TallerCommand {

	private DiscoveryClient discoveryClient;

	// Client
	private WebClient rest;

	private String uri = "ms-gestion-taller-command";

	public TallerCommandImpl(WebClient.Builder builder, DiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
		this.rest = builder.baseUrl(this.getURI() + "/talleres-command").build();
	}

	@Override
	public void enviar(TallerDTO tallerDTO) {
		try {
			System.out.println("pre post enviar -> command"+tallerDTO);
			
			rest.post()
	        .uri("")
	        .body(BodyInserters.fromValue(tallerDTO))
	        .retrieve()
	        .bodyToMono(String.class)
	        .subscribe(System.out::println);
			
			System.out.println("post enviar-> command");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private String getURI() {
		List<ServiceInstance> instances = discoveryClient.getInstances(uri);

		if (Objects.isNull(instances) || instances.isEmpty()) {
			return null;
		}
		String uri = instances.get(0).getUri().toString();
		log.info("uri" + uri);
		return uri;
	}

}

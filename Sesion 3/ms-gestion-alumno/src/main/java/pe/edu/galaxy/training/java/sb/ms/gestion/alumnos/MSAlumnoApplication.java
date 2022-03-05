package pe.edu.galaxy.training.java.sb.ms.gestion.alumnos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient

@SpringBootApplication
public class MSAlumnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MSAlumnoApplication.class, args);
	}

}

package br.org.upe.eventhub;

import br.org.upe.eventhub.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventhubApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventhubApplication.class, args);
	}

}

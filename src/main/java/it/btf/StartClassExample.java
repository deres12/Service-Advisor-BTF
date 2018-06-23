package it.btf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.btf.model.Persona;
import it.btf.repository.PersonaRepository;

@SpringBootApplication
public class StartClassExample {
	
	private static final Logger log = LoggerFactory.getLogger(StartClassExample.class);

	public static void main(String[] args) {
		//log.info("Customers found with findAll():");
		SpringApplication.run(StartClassExample.class, args);
	}
	
	
	@Bean(name="repositoryCommandLine")
	public CommandLineRunner commandLineRunner(PersonaRepository repository) {
		return (args) -> {

			Persona a=new Persona("assda","prova", "aaa@aaa","adsadsad","asasa");

			repository.save(a);
			
			
			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Persona customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			repository.findById("assda")
				.ifPresent(customer -> {
					log.info("Utente found with findById(\"assda\"):");
					log.info("--------------------------------");
					log.info(customer.toString());
					log.info("");
				});

			// fetch customers by last name
			log.info("Utente found with findByLastName('prova'):");
			log.info("--------------------------------------------");
			repository.findByEmail("prova").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}

}

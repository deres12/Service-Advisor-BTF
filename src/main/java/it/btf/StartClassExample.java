package it.btf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.btf.model.Cliente;
import it.btf.repository.FornitoreRepository;
import it.btf.repository.OffertaRepository;
import it.btf.repository.PersonaRepository;
import it.btf.repository.ProfessioneRepository;
import it.btf.repository.RichiestaClienteRepository;
import it.btf.repository.ServizioRepository;

@SpringBootApplication
public class StartClassExample {
	
	private static final Logger log = LoggerFactory.getLogger(StartClassExample.class);

	public static void main(String[] args) {
		//log.info("Customers found with findAll():");
		SpringApplication.run(StartClassExample.class, args);
	}
	
	
	@Bean(name="repositoryCommandLine")
	public CommandLineRunner commandLineRunner(
			PersonaRepository personaRep,FornitoreRepository fornitoreRep, 
			OffertaRepository offertaRep, ProfessioneRepository professioneRep,
			RichiestaClienteRepository richiestaCliRep, 
			ServizioRepository servizoRep) {
		return (args) -> {

			Cliente a=new Cliente("assda","prova","adsadsad","asasa", "aaa@aaa");

			personaRep.save(a);
			
			
			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Cliente customer : personaRep.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			personaRep.findById("aaa@aaa")
				.ifPresent(customer -> {
					log.info("Utente found with findById(\"aaa@aaa\"):");
					log.info("--------------------------------");
					log.info(customer.toString());
					log.info("");
					System.err.println("ECCOLOOOOO PER ID");
				});

			// fetch customers by last name
			log.info("Utente found with findByLastName('prova'):");
			log.info("--------------------------------------------");
			personaRep.findByEmail("prova").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}

}

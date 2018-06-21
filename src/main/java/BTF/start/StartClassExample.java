package BTF.start;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import model.User;
import repository.UtenteRepository;

@SpringBootApplication
public class StartClassExample {
	private static final Logger log = LoggerFactory.getLogger(StartClassExample.class);

	public static void main(String[] args) {
		log.info("Customers found with findAll():");
		SpringApplication.run(StartClassExample.class, args);
	}
	
	@Bean(name="repositoryCommandLine")
	public CommandLineRunner commandLineRunner(UtenteRepository repository) {
		return (args) -> {
			
			log.info("Customers found with findAll():");
			// save a couple of customers
			repository.save(new User("jack","Jack", "Bauer","via degli angeli"));
			repository.save(new User("chloe","Chloe", "O'Brian","via degli angeli"));
			repository.save(new User("kim","Kim", "Bauer","via degli angeli"));
			repository.save(new User("david","David", "Palmer","via degli angeli"));
			repository.save(new User("michelle","Michelle", "Dessler","via degli angeli"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (User customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			repository.findById("jack")
				.ifPresent(customer -> {
					log.info("Utente found with findById(\"jack\"):");
					log.info("--------------------------------");
					log.info(customer.toString());
					log.info("");
				});

			// fetch customers by last name
			log.info("Utente found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}

}

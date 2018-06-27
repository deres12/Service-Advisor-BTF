package it.btf;

import it.btf.model.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.btf.repository.FornitoreRepository;
import it.btf.repository.OffertaRepository;
import it.btf.repository.PersonaRepository;
import it.btf.repository.ProfessioneRepository;
import it.btf.repository.RichiestaClienteRepository;
import it.btf.repository.ServizioRepository;

import java.util.Date;

@SpringBootApplication
public class StartClassExample {

	private static final Logger log = LoggerFactory.getLogger(StartClassExample.class);

	public static void main(String[] args) {
		// log.info("Customers found with findAll():");
		SpringApplication.run(StartClassExample.class, args);
	}

	/*************************
	 * INSERIMENTO DATI DA CODICE
	 ******************************************/

	@Bean(name = "repositoryCommandLine")
	public CommandLineRunner commandLineRunner(PersonaRepository personaRep, FornitoreRepository fornitoreRep,
			OffertaRepository offertaRep, ProfessioneRepository professioneRep,
			RichiestaClienteRepository richiestaCliRep, ServizioRepository servizoRep) {
		return (args) -> {

			Cliente a = new Cliente("assda", "prova", "adsadsad", "asasa", "aaa@aaa", "prova");
			Cliente b = new Cliente("assda", "prova", "adsadsad", "asasa", "sfsdfsdf@aaa", "prova");
			Cliente c = new Cliente("assda", "prova", "adsadsad", "asasa", "sfsdfsdf@sdsd", "prova");
			personaRep.save(b);
			personaRep.save(c);
			Professione prof = new Professione();
			// prof.addFornitori(fornit);
			prof.setNome("idraulico");
			Fornitore fornit = new Fornitore();
			fornit.setNome("stefano");
			fornit.setCognome("carrino");
			fornit.setDescrizione("lavoro da 20 anni nel campo ellettrico, offro supporto per qualsiasi evenienza");
			fornit.setEmail("s.carrino@yahoo.it");
			fornit.setNumero("aaaa");
			fornit.setProfessione(prof);
			prof.addFornitori(fornit);

			
			fornit.setTimeBirth(new Date());
			fornit.setUsername("pippo");
			fornit.setValutazione(0);
			fornit.setVia("asdasda");

			fornit.setPass("prova");
			Servizio serv1 = new Servizio();
			serv1.setDescrizione("fdafhauidfa");
			servizoRep.save(serv1);
			prof.addServizio(serv1);
			fornit.addServizio(serv1);
			professioneRep.save(prof);
			fornit.setProfessione(prof);
			fornitoreRep.save(fornit);
			Servizio serv2 = new Servizio();
			serv2.setDescrizione("fdafhauidfa");
			servizoRep.save(serv2);
			personaRep.save(a);
			
			RichiestaCliente rich= new RichiestaCliente();
			rich.setCliente(a);
			rich.setDataFine(new Date());
			rich.setDataInizio(new Date());
			rich.setDescrizione("pipppppppppaspdaspddpa");
			rich.setPrezzoMassimo(100);
			rich.setServizioRichiesto(serv1);
			rich.setFornitore(fornit);
			rich.setVia("Via carlo antonio");
			richiestaCliRep.save(rich);
			
			Offerta offer=new Offerta();
			offer.setDescrizione("esempio di offerta");
			offer.setFornitore(fornit);
			offer.setPrezzo(95);
			offer.setRichiesta(rich);
			offertaRep.save(offer);
			
			
			Fornitore prova2 = new Fornitore();
			prova2.setNome("stefano");
			prova2.setCognome("carrino");
			prova2.setDescrizione("lavoro da 20 anni nel campo ellettrico, offro supporto per qualsiasi evenienza");
			prova2.setEmail("esempio@gggg.vbb");
			prova2.setNumero("aaaa");
			prova2.setProfessione(prof);
			prova2.setTimeBirth(new Date());
			prova2.setUsername("pippo");
			prova2.setValutazione(0);
			prova2.setVia("asdasda");
			prova2.setPass("asdasda");
			prova2.addServizio(serv1);
			fornitoreRep.save(prova2);
			
			RichiestaCliente rich2= new RichiestaCliente();
			rich2.setCliente(a);
			rich2.setDataFine(new Date());
			rich2.setDataInizio(new Date());
			rich2.setDescrizione("pipppppppppaspdaspddpa");
			rich2.setPrezzoMassimo(100);
			rich2.setServizioRichiesto(serv2);
			rich2.setFornitore(prova2);
			rich2.setVia("Via carlo antonio");
			richiestaCliRep.save(rich2);
			
			
			Offerta offer2=new Offerta();
			offer2.setDescrizione("dfdsfdsf");
			offer2.setFornitore(prova2);
			offer2.setRichiesta(rich);
			offer2.setPrezzo(100);
			offertaRep.save(offer2);
			
			Offerta offer3=new Offerta();
			offer3.setDescrizione("dfdsfdsf");
			offer3.setFornitore(fornit);
			offer3.setRichiesta(rich2);
			offer3.setPrezzo(100);
			offertaRep.save(offer3);
			
			
			
			
			/*for (Servizio servizio : servizoRep.findByDescrizione("fdafhauidfa")) {
				prof.addServizio(servizio);
				fornit.addServizio(servizio);
			}*/
			//System.err.println(serv1.getId());
			//System.err.println(serv2.getId());
			//fornitoreRep.save(fornit);

			// servizoRep.findByDescrizione("fdafhauidfa")

			/*
			 * Professione prof=new Professione();
			 * 
			 * personaRep.save(a); for (Servizio servizo :
			 * servizoRep.findByDescrizione("fdafhauidfa")) { prof.addServizio(serv1); }
			 * 
			 * professioneRep.save(prof);
			 */

			// servizoRep.findOne(serv1);
			// prof.addServizio(serv1);

			/*
			 * // fetch all customers log.info("Customers found with findAll():");
			 * log.info("-------------------------------"); for (Cliente customer :
			 * personaRep.findAll()) { log.info(customer.toString()); } log.info("");
			 * 
			 * // fetch an individual customer by ID personaRep.findById("aaa@aaa")
			 * .ifPresent(customer -> {
			 * log.info("Utente found with findById(\"aaa@aaa\"):");
			 * log.info("--------------------------------"); log.info(customer.toString());
			 * log.info(""); System.err.println("ECCOLOOOOO PER ID");
			 * 
			 * });
			 * 
			 * // fetch customers by last name
			 * log.info("Utente found with findByLastName('prova'):");
			 * log.info("--------------------------------------------");
			 * personaRep.findByEmail("prova").forEach(bauer -> {
			 * log.info(bauer.toString()); }); // for (Customer bauer :
			 * repository.findByLastName("Bauer")) { // log.info(bauer.toString()); // }
			 * log.info("");
			 */
		};
	}

}

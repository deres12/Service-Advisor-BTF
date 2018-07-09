package it.btf;

import it.btf.model.*;

import it.btf.utility.Position;
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

import it.btf.utility.StringHashing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
			Luogo pos = new Luogo();
			pos.setPaese("Milano");
			pos.setNazione("IT");
			pos.setNumeroCivico(10);
			pos.setVia("Negroli");
			pos.setLatit(Position.getDoubleFromAddress(pos.toString(), "lat"));
			pos.setLongit(Position.getDoubleFromAddress(pos.toString(), "lng"));
			/*pos.setLatit(0);
			pos.setLongit(0);*/

			Luogo pos2 = new Luogo();
			pos2.setPaese("Milano");
			pos2.setNazione("IT");
			pos2.setNumeroCivico(50);
			pos2.setVia("Giancarlo Sismondi");
			pos2.setLatit(Position.getDoubleFromAddress(pos2.toString(), "lat"));
			pos2.setLongit(Position.getDoubleFromAddress(pos2.toString(), "lng"));
			/*pos2.setLatit(0);
			pos2.setLongit(0);*/


			Luogo pos3 = new Luogo();
			pos3.setPaese("Milano");
			pos3.setNazione("IT");
			pos3.setNumeroCivico(15);
			pos3.setVia("Giacomo Zanella");
			pos3.setLatit(Position.getDoubleFromAddress(pos3.toString(), "lat"));
			pos3.setLongit(Position.getDoubleFromAddress(pos3.toString(), "lng"));
			/*pos3.setLatit(0);
			pos3.setLongit(0);*/

			Luogo pos4 = new Luogo();
			pos4.setPaese("Milano");
			pos4.setNazione("IT");
			pos4.setNumeroCivico(35);
			pos4.setVia("Giacomo Zanella");
			pos4.setLatit(Position.getDoubleFromAddress(pos4.toString(), "lat"));
			pos4.setLongit(Position.getDoubleFromAddress(pos4.toString(), "lng"));




			Cliente a = new Cliente("Alessandro", "Beninati", "alex", pos, "ale@com.com", StringHashing.sha1("1234"));
			Cliente b = new Cliente("Stefano", "Carrino", "ste", pos2, "sfsdfsdf@aaa", StringHashing.sha1("567"));
			Cliente c = new Cliente("Antonio", "prova", "anto", pos3, "sfsdfsdf@sdsd", StringHashing.sha1("prova"));
			personaRep.save(b);
			personaRep.save(c);

			Professione prof = new Professione();
			prof.setNome("idraulico");
			Fornitore fornit = new Fornitore();
			fornit.setNome("Stefano");
			fornit.setCognome("carrino");
			fornit.setDescrizione("Esperienza pluriennale, offro supporto per qualsiasi evenienza nel campo idraulico. Anche pronto intervento");
			fornit.setEmail("s.carrino@yahoo.it");
			fornit.setNumero("aaaa");
			fornit.setProfessione(prof);
			prof.addFornitori(fornit);


			fornit.setTimeBirth(new Date());
			fornit.setUsername("pippo");
			fornit.setValutazione(4);


			fornit.setVia(pos);


			fornit.setPass(StringHashing.sha1("prova"));

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

			RichiestaCliente rich = new RichiestaCliente();
			rich.setCliente(a);
			rich.setDataFine(new Date());
			rich.setDataInizio(new Date());
			rich.setDescrizione("Cerco gommista affidabile economico e veloce per cambio gomme.");
			rich.setPrezzoMassimo(500);
			rich.setServizioRichiesto(serv1);
			rich.setFornitore(fornit);
			rich.setVia(pos3);
			richiestaCliRep.save(rich);

			Offerta offer = new Offerta();
			offer.setDescrizione("esempio di offerta");
			offer.setFornitore(fornit);
			offer.setPrezzo(95);
			offer.setRichiesta(rich);
			offertaRep.save(offer);


			Fornitore prova2 = new Fornitore();
			prova2.setNome("Aldo");
			prova2.setCognome("carrino");
			prova2.setDescrizione("Specializzato in impiati idraulici domestici.");
			prova2.setEmail("esempio@gggg.vbb");
			prova2.setNumero("aaaa");

			prova2.setProfessione(prof.getId());
			prova2.setTimeBirth(new Date());
			prova2.setUsername("pippo");
			prova2.setValutazione(3);
			prova2.setVia(pos3);
			prova2.setPass(StringHashing.sha1("asdasda"));
			prova2.addServizio(serv1);
			fornitoreRep.save(prova2);

			RichiestaCliente rich2 = new RichiestaCliente();
			rich2.setCliente(a);
			rich2.setDataFine(new Date());
			rich2.setDataInizio(new Date());
			rich2.setDescrizione("Cerco idraulico per pronto intervento!");
			rich2.setPrezzoMassimo(100);
			rich2.setServizioRichiesto(serv2);
			rich2.setFornitore(prova2);
			rich2.setVia(pos3);
			richiestaCliRep.save(rich2);


			Offerta offer2 = new Offerta();
			offer2.setDescrizione("dfdsfdsf");
			offer2.setFornitore(prova2);
			offer2.setRichiesta(rich);
			offer2.setPrezzo(100);
			offertaRep.save(offer2);

			Offerta offer3 = new Offerta();
			offer3.setDescrizione("dfdsfdsf");
			offer3.setFornitore(fornit);
			offer3.setRichiesta(rich2);
			offer3.setPrezzo(100);
			offertaRep.save(offer3);
			List<Servizio> pippo = new ArrayList<Servizio>();
			pippo.add(serv2);
			Professione p = new Professione("gommista", pippo, null);
			Servizio example = new Servizio();
			example.setDescrizione("ciccio pasticcio");
			servizoRep.save(example);
			Professione example2 = new Professione();
			example2.setNome("elettricista");
			example2.addServizio(example);
			professioneRep.save(example2);

			Fornitore example3= new Fornitore();
            example3.setNome("stefano");
            example3.setCognome("carrino");
            example3.setDescrizione("Interventi elettrici di ogni tipo, rifacimento impianti. Pronto intervento");
            example3.setEmail("zzz@zzz.zzz");
            example3.setNumero("aaaa");

            example3.setProfessione(example2.getId());
            example3.setTimeBirth(new Date());
            example3.setUsername("pippo");
            example3.setValutazione(0);
            example3.setVia(pos3);
            example3.setPass(StringHashing.sha1("asdasda"));
            Servizio asss=new Servizio();
            asss.setId(example.getId());
            example3.addServizio(asss);
            fornitoreRep.save(example3);


			Fornitore example4= new Fornitore();
			example4.setNome("stefano");
			example4.setCognome("carrino");
			example4.setDescrizione("Interventi elettrici di ogni tipo, rifacimento impianti. Pronto intervento");
			example4.setEmail("email@zzz.zzz");
			example4.setNumero("aaaa");

			example4.setProfessione(example2.getId());
			example4.setTimeBirth(new Date());
			example4.setUsername("pippo");
			example4.setValutazione(0);
			example4.setVia(pos3);
			example4.setPass("asdasda");
			Servizio asss2=new Servizio();
			asss2.setId(example.getId());
			example4.addServizio(asss);
			fornitoreRep.save(example4);

			professioneRep.save(p);

			Fornitore example5= new Fornitore();
			example4.setNome("stefano");
			example4.setCognome("carrino");
			example4.setDescrizione("Interventi elettrici di ogni tipo, rifacimento impianti. Pronto intervento");
			example4.setEmail("nnnnn@zzz.zzz");
			example4.setNumero("aaaa");

			example4.setProfessione(example2.getId());
			example4.setTimeBirth(new Date());
			example4.setUsername("pippo");
			example4.setValutazione(0);
			example4.setVia(pos3);
			example4.setPass("asdasda");
			Servizio asss3=new Servizio();
			asss3.setId(example.getId());
			example4.addServizio(asss);
			fornitoreRep.save(example4);

			professioneRep.save(p);

			example4.setNome("Pippo");
			example4.setCognome("carrino");
			example4.setDescrizione("Interventi elettrici di ogni tipo, rifacimento impianti. Pronto intervento");
			example4.setEmail("asganauei@zzz.zzz");
			example4.setNumero("aaaa");

			example4.setProfessione(example2.getId());
			example4.setTimeBirth(new Date());
			example4.setUsername("pippo");
			example4.setValutazione(0);
			example4.setVia(pos4);
			example4.setPass("asdasda");
			asss2.setId(example.getId());
			example4.addServizio(asss);
			fornitoreRep.save(example4);

			professioneRep.save(p);

		};
	}

}

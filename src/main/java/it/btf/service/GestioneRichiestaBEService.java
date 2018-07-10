package it.btf.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.btf.dto.PersonaDTO;
import it.btf.dto.RichiestaDTO;
import it.btf.dto.ServizioDTO;
import it.btf.interf.GestioneRichiestaBE;
import it.btf.model.Cliente;
import it.btf.model.Fornitore;
import it.btf.model.Luogo;
import it.btf.model.RichiestaCliente;
import it.btf.model.Servizio;
import it.btf.repository.FornitoreRepository;
import it.btf.repository.PersonaRepository;
import it.btf.repository.RichiestaClienteRepository;
import it.btf.utility.Position;

@Service
@Transactional
public class GestioneRichiestaBEService implements GestioneRichiestaBE {

	@Autowired
	RichiestaClienteRepository servizioRepository;


	@Autowired
	PersonaRepository utenteRepository;
	@Autowired
	FornitoreRepository fornRepository;

	@Override
	public List<RichiestaDTO> loadByEmail(String email) {
		List<RichiestaDTO> richiesteDTOS = new ArrayList<RichiestaDTO>();


		List<RichiestaCliente> richieste= servizioRepository.myQuery(email);//servizioRepository.findRichiestaClienteByCliente(email);


		for(RichiestaCliente R : richieste) {
			RichiestaDTO ric = new RichiestaDTO();

			PersonaDTO pers = new PersonaDTO();
			ServizioDTO serv = new ServizioDTO();

			pers.setEmail(R.getCliente().getEmail());

			serv.setId(R.getServizioRichiesto().getId());


			ric.setDescrizione(R.getDescrizione());
			ric.setDataInizio(R.getDataInizio());
			ric.setDataFine(R.getDataFine());
			ric.setPrezzoMassimo(R.getPrezzoMassimo());

			ric.setPersona(pers);
			ric.setServizioRichiesto(serv);

			richiesteDTOS.add(ric);
		}

		return richiesteDTOS;
	}


	@Override
	public RichiestaCliente addRichiesta(RichiestaDTO richiesta) {
	    //System.err.println("ATTENZIONE: "+richiesta.getDescrizione());
		RichiestaCliente ric =new RichiestaCliente();
		Fornitore forn;
        Cliente cl;
        System.err.println("email:  ");
        System.err.println(richiesta.getEmailfornitore());
		if(utenteRepository.findById(richiesta.getPersona().getEmail()).isPresent()){
            cl=utenteRepository.findById(richiesta.getPersona().getEmail()).get();

            System.err.println("email:  ");
            System.err.println(richiesta.getEmailfornitore());
			if(fornRepository.findById(richiesta.getEmailfornitore()).isPresent()) {
				forn = fornRepository.findById(richiesta.getEmailfornitore()).get();
                ric.setFornitore(forn);
			}
				Servizio serv = new Servizio();
				//cl.setEmail(richiesta.getPersona().getEmail());
				//MANCANO ALTRI ATTRIBUTI
				if (richiesta.getServizioRichiesto() != null) {
					serv.setId(richiesta.getServizioRichiesto().getId());
					serv.setDescrizione(richiesta.getServizioRichiesto().getDescrizione());
					ric.setServizioRichiesto(serv);
				}
				ric.setVia(new Luogo(richiesta.getVia().getNumeroCivico(), richiesta.getVia().getVia(), richiesta.getVia().getPaese(), richiesta.getVia().getNazione(), Position.getDoubleFromAddress(richiesta.getVia().toString(), "lat"), Position.getDoubleFromAddress(richiesta.getVia().toString(), "lng")));

				ric.setCliente(cl);
				ric.setDescrizione(richiesta.getDescrizione());
				ric.setPrezzoMassimo(richiesta.getPrezzoMassimo());

				ric = servizioRepository.save(ric);
			}




		return ric;

	}

	@Override
	public List<RichiestaDTO> loadAll() {
		List<RichiestaDTO> richiestaDTOS = new ArrayList<RichiestaDTO>();
		List<RichiestaCliente> richieste = servizioRepository.findAll();

		for(RichiestaCliente r: richieste){
			RichiestaDTO ric = new RichiestaDTO();
			ric=new DozerBeanMapper().map(r, RichiestaDTO.class);
			richiestaDTOS.add(ric);
		}

		return richiestaDTOS;
	}


}

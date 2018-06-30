package it.btf.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import it.btf.dto.PersonaDTO;
import it.btf.dto.ServizioDTO;
import it.btf.model.Cliente;
import it.btf.model.RichiestaCliente;
import it.btf.model.Servizio;
import it.btf.repository.PersonaRepository;
import it.btf.repository.RichiestaClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.btf.dto.RichiestaDTO;
import it.btf.interf.GestioneRichiestaBE;

@Service
@Transactional
public class GestioneRichiestaBEService implements GestioneRichiestaBE {

	@Autowired
	RichiestaClienteRepository servizioRepository;


	@Autowired
	PersonaRepository utenteRepository;

	@Override
	public List<RichiestaDTO> loadByEmail(String email) {
		List<RichiestaDTO> richiesteDTOS = new ArrayList<RichiestaDTO>();


		List<RichiestaCliente> richieste= servizioRepository.myQuery(email);//servizioRepository.findRichiestaClienteByCliente(email);


		if(richieste.size()>0){
			for(RichiestaCliente R:richieste) {
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

				//AGGIUNGO ALLA LISTA DI RICHIESTEdto
				richiesteDTOS.add(ric);
			}
		}

		return richiesteDTOS;
	}


	@Override
	public void addRichiesta(RichiestaDTO richiesta) {
		RichiestaCliente ric =new RichiestaCliente();
		Cliente cl=new Cliente();
		Servizio serv=new Servizio();

		/*cl.setUsername(richiesta.getCliente().getUsername());
		cl.setCognome(richiesta.getCliente().getCognome());
		cl.setNome(richiesta.getCliente().getNome());*/


		cl.setEmail(richiesta.getPersona().getEmail());
		//MANCANO ALTRI ATTRIBUTI


		serv.setId(richiesta.getServizioRichiesto().getId());
		serv.setDescrizione(richiesta.getServizioRichiesto().getDescrizione());

		ric.setServizioRichiesto(serv);
		ric.setCliente(cl);
		ric.setDescrizione(richiesta.getDescrizione());
		//ric.setDataFine(richiesta.getDataFine());
		//ric.setDataInizio(richiesta.getDataInizio());
		ric.setPrezzoMassimo(richiesta.getPrezzoMassimo());

		servizioRepository.save(ric);
	}



}

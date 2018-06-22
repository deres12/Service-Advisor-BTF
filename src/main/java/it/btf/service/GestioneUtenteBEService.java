package it.btf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.btf.dto.RispostaDTO;
import it.btf.dto.UtenteDTO;
import it.btf.interf.GestioneUtenteBE;
import it.btf.model.User;
import it.btf.repository.UtenteRepository;

@Service
@Transactional
public class GestioneUtenteBEService implements GestioneUtenteBE {

	@Autowired
	UtenteRepository utenteRepository;

	@Override
	public UtenteDTO load(String username) {
		User utente = utenteRepository.findById(username).orElse(new User(username,null,null,null,null));
		return new UtenteDTO(utente.getNome(),utente.getCognome(),utente.getUsername(),utente.getVia(),utente.getEmail());
	}

	/*@Override
	public ExampleEntity add(ExampleEntity user) {
		// TODO Auto-generated method stub
		ExampleEntity a=user;
		utenteRepository.save(a);
		return user;
	}*/

	/*@Override
	public void saveAndFlush(UtenteDTO utenteDto) {
		// User utente = utenteRepository.findById(username).orElse(new
		// User(username,null,null,null));

	}*/

	/*@Override
	public void insert(ExampleEntity utente) {
		// TODO Auto-generated method stub
		utenteRepository.saveAndFlush(utente);
				//return new UtenteDTO(utente.getUsername(),utente.getNome(),utente.getCognome(),utente.getVia());
		
	}*/
}

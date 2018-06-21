package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import controller.UtenteDTO;
import interf.GestioneUtenteBE;
import model.User;
import repository.UtenteRepository;

@Service
@Transactional
public class GestioneUtenteBEService implements GestioneUtenteBE {

	@Autowired
	UtenteRepository utenteRepository;

	@Override
	public UtenteDTO load(String username) {
		User utente = utenteRepository.findById(username).orElse(new User());
		return new UtenteDTO(utente.getUsername(), utente.getNome(), utente.getCognome(), utente.getVia());
	}

	/*@Override
	public void saveAndFlush(UtenteDTO utenteDto) {
		// User utente = utenteRepository.findById(username).orElse(new
		// User(username,null,null,null));

	}*/

	@Override
	public void insert(User utente) {
		// TODO Auto-generated method stub
		utenteRepository.saveAndFlush(utente);
				//return new UtenteDTO(utente.getUsername(),utente.getNome(),utente.getCognome(),utente.getVia());
		
	}
}

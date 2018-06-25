package it.btf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.btf.dto.PersonaDTO;
import it.btf.interf.GestioneUtenteBE;
import it.btf.model.Cliente;
import it.btf.repository.PersonaRepository;

@Service
@Transactional
public class GestioneUtenteBEService implements GestioneUtenteBE {

	@Autowired
	PersonaRepository utenteRepository;

	@Override
	public PersonaDTO load(String username) {
		Cliente utente = utenteRepository.findById(username).orElse(new Cliente(username,null,null,null,null));
		return new PersonaDTO(utente.getNome(),utente.getCognome(),utente.getUsername(),utente.getVia(),utente.getEmail());
	}

}

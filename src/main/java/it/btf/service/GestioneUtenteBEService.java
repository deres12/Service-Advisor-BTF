package it.btf.service;

import java.util.ArrayList;
import java.util.List;

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
	public List<PersonaDTO> load(String username) {
		List<PersonaDTO> persone=new ArrayList<PersonaDTO>();
		
		List<Cliente> utente = utenteRepository.findByUsername(username)/*.orElse(new ArrayList<Cliente>(new Cliente(username,null,null,null,null,null)))*/;
		if(utente.size()==0) {
			return persone;
		}else {
			for(Cliente a:utente) {
				persone.add(new PersonaDTO(a.getNome(),a.getCognome(),a.getUsername(),a.getVia(),a.getEmail(),""));
			}
		}
		
		return persone;
	}

	@Override
	public void addUser(PersonaDTO utente) {
		Cliente cliente = new Cliente();
		cliente.setEmail(utente.getEmail());
		cliente.setNome(utente.getNome());
		cliente.setCognome(utente.getCognome());
		cliente.setVia(utente.getVia());
		cliente.setUsername(utente.getUsername());
		cliente.setPass(utente.getPass());
		utenteRepository.save(cliente);
	}

}

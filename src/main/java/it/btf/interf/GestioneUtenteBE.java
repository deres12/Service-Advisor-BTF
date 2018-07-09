package it.btf.interf;

import java.util.Optional;

import it.btf.dto.PersonaDTO;
import it.btf.model.Cliente;

public interface GestioneUtenteBE {
	
	public int addUser(PersonaDTO utente);
	public boolean login(String email, String password);
	
	public Optional<Cliente> load(String email);
	public PersonaDTO loadById(String email);
}

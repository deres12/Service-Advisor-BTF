package it.btf.interf;

import java.util.List;

import it.btf.dto.PersonaDTO;

public interface GestioneUtenteBE {
	
	public List<PersonaDTO> load(String username);
	public void addUser(PersonaDTO utente);

}

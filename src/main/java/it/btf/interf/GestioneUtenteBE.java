package it.btf.interf;

import it.btf.dto.PersonaDTO;

public interface GestioneUtenteBE {
	
	public PersonaDTO load(String username);

}

package it.btf.interf;

import java.util.List;

import it.btf.dto.PersonaDTO;
import it.btf.dto.ProfessioneDTO;
import it.btf.dto.ServizioDTO;

public interface GestioneUtenteBE {
	
	public List<PersonaDTO> load(String username);
	public String addUser(PersonaDTO utente);
	public PersonaDTO loadById(PersonaDTO dto);
}

package it.btf.interf;

import java.util.List;

import it.btf.dto.PersonaDTO;
import it.btf.dto.ProfessioneDTO;
import it.btf.dto.ServizioDTO;
import it.btf.utility.DatabaseException;
import org.springframework.http.ResponseEntity;

public interface GestioneUtenteBE {
	
	public boolean login(String email, String password);
	public int addUser(PersonaDTO utente);
	
	public List<PersonaDTO> load(String username);
	public PersonaDTO loadById(PersonaDTO dto);
}

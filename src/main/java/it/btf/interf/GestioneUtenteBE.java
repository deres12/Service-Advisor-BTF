package it.btf.interf;

import java.util.List;

import it.btf.dto.PersonaDTO;
import it.btf.dto.ProfessioneDTO;
import it.btf.dto.ServizioDTO;
import it.btf.utility.DatabaseException;
import org.springframework.http.ResponseEntity;

public interface GestioneUtenteBE {
	
	public List<PersonaDTO> load(String username);
	public ResponseEntity addUser(PersonaDTO utente) throws DatabaseException;
	public PersonaDTO loadById(PersonaDTO dto);
}

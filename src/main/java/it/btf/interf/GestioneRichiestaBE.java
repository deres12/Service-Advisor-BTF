package it.btf.interf;

import java.util.List;

import it.btf.dto.RichiestaDTO;

public interface GestioneRichiestaBE {
	public List<RichiestaDTO> loadByEmail(String email);
	public void addRichiesta(RichiestaDTO richiesta);
	public List<RichiestaDTO> loadAll();

}

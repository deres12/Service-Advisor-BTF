package it.btf.interf;

import java.util.List;

import it.btf.dto.RichiestaDTO;

public interface GestioneRichiestaBE {
	public List<RichiestaDTO> load(String username);
	public void addRichiesta(RichiestaDTO richiesta);
}

package it.btf.interf;

import java.util.List;

import it.btf.dto.RichiestaDTO;
import it.btf.model.RichiestaCliente;

public interface GestioneRichiestaBE {
	public List<RichiestaDTO> loadByEmail(String email);
	public RichiestaCliente addRichiesta(RichiestaDTO richiesta);
	public List<RichiestaDTO> loadAll();

}

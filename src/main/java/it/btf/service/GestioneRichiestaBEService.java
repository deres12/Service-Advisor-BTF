package it.btf.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.btf.dto.RichiestaDTO;
import it.btf.interf.GestioneRichiestaBE;

@Service
@Transactional
public class GestioneRichiestaBEService implements GestioneRichiestaBE {

	@Override
	public List<RichiestaDTO> load(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRichiesta(RichiestaDTO richiesta) {
		// TODO Auto-generated method stub
		
	}

}

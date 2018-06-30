package it.btf.interf;

import it.btf.dto.ServizioDTO;
import it.btf.model.Servizio;

import java.util.List;

public interface GestioneServiziBE {

    public List<ServizioDTO> loadServiceByProf(String professione);
}

package it.btf.interf;

import java.util.List;

import it.btf.dto.ServizioDTO;

public interface GestioneServiziBE {

    public List<ServizioDTO> loadServiceByProf(String professione);
}

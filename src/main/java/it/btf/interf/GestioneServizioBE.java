package it.btf.interf;

import it.btf.dto.ServizioDTO;

import java.util.List;

public interface GestioneServizioBE {

    public List<ServizioDTO> loadAllByProf(Long id);
    public List<ServizioDTO> loadAllService();
}

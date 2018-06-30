package it.btf.interf;

import it.btf.dto.ProfessioneDTO;

import java.util.List;

public interface GestioneProfessioneBE {

    public List<ProfessioneDTO> loadAll();
    public List<ProfessioneDTO> loadAllWithService();
}

package it.btf.interf;

import it.btf.dto.VisiteGgDTO;
import java.util.List;


public interface GestioneVisiteBE {

    public void addVisita(String email);
    List<VisiteGgDTO> contaVisite(String email);

}

package it.btf.interf;

import java.util.Map;

public interface GestioneVisiteBE {

    public void addVisita(String email);
    Map<String,Long> contaVisite(String email);

}

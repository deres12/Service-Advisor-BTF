package it.btf.interf;

import it.btf.dto.OffertaDTO;
import it.btf.model.Offerta;

import java.util.List;

public interface GestioneOfferteBE {
    public void addOfferta(OffertaDTO dto);
    public List<Offerta> loadByRichiesta(String ricId);
    List<OffertaDTO> loadOfferteByFornitore(String id);
    List<OffertaDTO> loadOfferteByCliente(String id);
}

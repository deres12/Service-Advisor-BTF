package it.btf.interf;

import java.util.List;

import it.btf.dto.FornitoreDTO;
import it.btf.dto.RicercaFornitoriDTO;

public interface GestioneFornitoreBE {

    public List<FornitoreDTO> loadAllFornitore();
    public List<FornitoreDTO> loadAllGuestFornByComune(String comune);
    public List<RicercaFornitoriDTO> loadAllFornByDistance(RicercaFornitoriDTO fornitore);
}

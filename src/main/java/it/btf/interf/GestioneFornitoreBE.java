package it.btf.interf;

import it.btf.dto.FornitoreDTO;
import it.btf.dto.LuogoDTO;
import it.btf.dto.RicercaFornitoriDTO;
import it.btf.model.Fornitore;

import java.util.List;

public interface GestioneFornitoreBE {

    public List<FornitoreDTO> loadAllFornitore();
    public List<FornitoreDTO> loadAllGuestFornByComune(String comune);
    public List<RicercaFornitoriDTO> loadAllFornByDistance(RicercaFornitoriDTO fornitore);
}

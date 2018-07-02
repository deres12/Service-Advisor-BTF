package it.btf.interf;

import it.btf.dto.FornitoreDTO;
import it.btf.model.Fornitore;

import java.util.List;

public interface GestioneFornitoreBE {

    public List<FornitoreDTO> loadAllFornitore();
    public List<FornitoreDTO> loadAllGuestFornByComune(String comune);
}

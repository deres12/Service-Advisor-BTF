package it.btf.service;

import it.btf.dto.OffertaDTO;
import it.btf.interf.GestioneOfferteBE;
import it.btf.model.Fornitore;
import it.btf.model.Offerta;
import it.btf.model.RichiestaCliente;
import it.btf.repository.OffertaRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GestioneOfferteBEService implements GestioneOfferteBE {

    @Autowired
    OffertaRepository offertaRepository;



    @Override
    public void addOfferta(OffertaDTO dto) {

/*
        RichiestaCliente ric = new RichiestaCliente();
        Fornitore forn = new Fornitore();


        ric.setId(dto.getRichiesta().getId());

        forn.setEmail(dto.getFornitore().getEmail());

        off.setFornitore(forn);
        off.setRichiesta(ric);
        off.setPrezzo(dto.getPrezzo());
        off.setDescrizione(dto.getDescrizione());

*/
        Offerta off =new DozerBeanMapper().map(dto, Offerta.class);

        offertaRepository.save(off);
    }

    @Override
    public List<Offerta> loadByRichiesta(String ricId) {



        return null;
    }


}

package it.btf.service;

import it.btf.dto.OffertaDTO;
import it.btf.dto.RichiestaDTO;
import it.btf.interf.GestioneOfferteBE;
import it.btf.model.Fornitore;
import it.btf.model.Offerta;
import it.btf.model.RichiestaCliente;
import it.btf.repository.OffertaRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Override
    public List<OffertaDTO> loadOfferteByFornitore(String id) {
        List<Offerta> offertaList = new ArrayList<Offerta>();
        List<OffertaDTO> offertaDTOS = new ArrayList<OffertaDTO>();


        offertaList= offertaRepository.findAllByFornitore_Email(id);

        for(Offerta off : offertaList) {
           // OffertaDTO offDTO = new DozerBeanMapper().map(off, OffertaDTO.class);
            OffertaDTO offDTO = new OffertaDTO();

            offDTO.setDescrizione(off.getDescrizione());
            offDTO.setPrezzo(off.getPrezzo());

            RichiestaDTO richiestaDTO = new DozerBeanMapper().map(off.getRichiesta(), RichiestaDTO.class);

            offDTO.setRichiesta(richiestaDTO);

            offertaDTOS.add(offDTO);
        }

        return offertaDTOS;
    }


}

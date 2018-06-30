package it.btf.service;

import it.btf.dto.FornitoreDTO;
import it.btf.dto.ServizioDTO;
import it.btf.interf.GestioneFornitoreBE;
import it.btf.model.Fornitore;
import it.btf.model.Servizio;
import it.btf.repository.FornitoreRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GestioneFornitoreBEService implements GestioneFornitoreBE {

    @Autowired
    FornitoreRepository fornitoreRepository;

    @Override
    public List<FornitoreDTO> loadAllFornitore() {

        List<FornitoreDTO> fornitoriDTOS = new ArrayList<FornitoreDTO>();
        List<Fornitore> fornitori= fornitoreRepository.findAll();


        for(Fornitore f : fornitori) {
            List<ServizioDTO> servsDTO = new ArrayList<ServizioDTO>();
            FornitoreDTO fornDTO=new FornitoreDTO();
            fornDTO.setDescrizione(f.getDescrizione());
            fornDTO.setValutazione(f.getValutazione());
            fornDTO.setNome(f.getNome());
            fornDTO.setNomeProfessione(f.getProfessione().getNome());

            for(Servizio S : f.getServizi()){
                servsDTO.add(new ServizioDTO(S.getId(),S.getDescrizione()));
            }
            fornDTO.setServizi(servsDTO);
            fornitoriDTOS.add(fornDTO);
        }
        return fornitoriDTOS;
    }


}

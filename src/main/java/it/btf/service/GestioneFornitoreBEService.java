package it.btf.service;

import it.btf.dto.FornitoreDTO;
import it.btf.dto.LuogoDTO;
import it.btf.dto.RicercaFornitoriDTO;
import it.btf.dto.ServizioDTO;
import it.btf.interf.GestioneFornitoreBE;
import it.btf.model.Fornitore;
import it.btf.model.Guest;
import it.btf.model.Servizio;
import it.btf.repository.FornitoreRepository;
import it.btf.utility.Position;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.ListableBeanFactory;
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
            fornDTO.setEmail(f.getEmail());
            fornDTO.setNomeProfessione(f.getProfessione().getNome());

            for(Servizio S : f.getServizi()){
                servsDTO.add(new ServizioDTO(S.getId(),S.getDescrizione()));
            }
            fornDTO.setServizi(servsDTO);
            fornitoriDTOS.add(fornDTO);
        }
        return fornitoriDTOS;
    }
/*
    @Override
    public List<FornitoreDTO> loadAllByComune(String comune) {
        List<FornitoreDTO> fornitoreDTOS = new ArrayList<FornitoreDTO>();
        List<Fornitore> fornitori = fornitoreRepository.findAllByComune(comune);

        for(Fornitore f:fornitori){
         FornitoreDTO forn=  new DozerBeanMapper().map(f, FornitoreDTO.class);
         fornitoreDTOS.add(forn);
        }
        return fornitoreDTOS;
    }
*/
@Override
public List<FornitoreDTO> loadAllGuestFornByComune(String comune) {
    List<FornitoreDTO> fornitoreDTOS = new ArrayList<FornitoreDTO>();
    List<Fornitore> fornitori = fornitoreRepository.findAllByComune(comune);


    for(Fornitore f:fornitori){
        FornitoreDTO forn=  new FornitoreDTO();
        forn.setComune(f.getVia().getPaese());
        forn.setNome(f.getNome());
        forn.setDescrizione(f.getDescrizione());
        forn.setNomeProfessione(f.getProfessione().getNome());
        forn.setLatit(f.getVia().getLatit());
        forn.setLongit(f.getVia().getLongit());

        fornitoreDTOS.add(forn);
    }
    return fornitoreDTOS;
}

    @Override
    public List<RicercaFornitoriDTO> loadAllFornByDistance(RicercaFornitoriDTO fornitore) {
        List<RicercaFornitoriDTO> fornDTOS = new ArrayList<RicercaFornitoriDTO>();
        List<Fornitore>  forns = new ArrayList<Fornitore>();


        String via= fornitore.getCivico()+", "+fornitore.getVia()+", "+fornitore.getCity()+", "+fornitore.getNazione();
        Double raggio= fornitore.getRaggio();
        Double lat = Position.getDoubleFromAddress(via, "lat");
        Double lon = Position.getDoubleFromAddress(via, "lng");



        forns = fornitoreRepository.findAll();

        for(Fornitore f:forns){

            Double latitudine =f.getVia().getLatit();
            Double longitudine=f.getVia().getLongit();
            Double dist = Position.distance(lat,lon,latitudine,longitudine,"K");

            System.out.println(dist);

            if(dist<=raggio){
                RicercaFornitoriDTO forn=new RicercaFornitoriDTO();
                forn.setCity(f.getVia().getPaese());
                forn.setNome(f.getNome());
                forn.setDescrizione(f.getDescrizione());
                forn.setLat(f.getVia().getLatit());
                forn.setLongi(f.getVia().getLongit());


                fornDTOS.add(forn);
            }
        }

    return fornDTOS;
    }


}

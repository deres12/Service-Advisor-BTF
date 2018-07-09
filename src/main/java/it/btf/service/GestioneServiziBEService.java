package it.btf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.btf.dto.ServizioDTO;
import it.btf.interf.GestioneServiziBE;
import it.btf.repository.ProfessioneRepository;
import it.btf.repository.ServizioRepository;

@Service
@Transactional
public class GestioneServiziBEService implements GestioneServiziBE {
    @Autowired
    ServizioRepository servizioRepository;

    @Autowired
    ProfessioneRepository professioneRepository;



    @Override
    public List<ServizioDTO> loadServiceByProf(String professione) {


        /*
        Optional <Professione> f =professioneRepository.findById(new Long(1));
        if(f.isPresent()){
            return f.get().getServizi();

        }



        List<ServizioDTO> risposta= new ArrayList<ServizioDTO>();

       /* List<Servizio> servizi= servizioRepository.serviziByProfessione(professione);
        if(servizi.size()>0){
            for(Servizio S : servizi){
               ServizioDTO serv =new DozerBeanMapper().map(S, ServizioDTO.class);
               risposta.add(serv);
            }
        }
*/

        return null;

    }
}

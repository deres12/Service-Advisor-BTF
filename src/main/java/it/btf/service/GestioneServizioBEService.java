package it.btf.service;

import it.btf.dto.ServizioDTO;
import it.btf.interf.GestioneServizioBE;
import it.btf.model.Servizio;
import it.btf.repository.ServizioRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GestioneServizioBEService implements GestioneServizioBE {

    @Autowired
    ServizioRepository servRepository;

    @Override
    public List<ServizioDTO> loadAll() {
        List<ServizioDTO> profDto=new ArrayList<ServizioDTO>();
        List <Servizio> professioni= servRepository.findAll();

        //List<ServizioDTO> servizio= new DozerBeanMapper().map(servRepository.findAll(),List<ServizioDTO>);

        for(Servizio p: professioni){
            profDto.add(new ServizioDTO(p.getId(),p.getDescrizione()));
        }
        return profDto;
    }
}

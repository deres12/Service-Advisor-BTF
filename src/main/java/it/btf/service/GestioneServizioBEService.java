package it.btf.service;

import it.btf.dto.ProfessioneDTO;
import it.btf.dto.ServizioDTO;
import it.btf.interf.GestioneServizioBE;
import it.btf.model.Professione;
import it.btf.model.Servizio;
import it.btf.repository.ProfessioneRepository;
import it.btf.repository.ServizioRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GestioneServizioBEService implements GestioneServizioBE {

    @Autowired
    ServizioRepository servRepository;

    @Autowired
    ProfessioneRepository professioneRepository;

    @Override

    public List<ServizioDTO> loadAllByProf(Long id) {
        List<ServizioDTO> servDto=new ArrayList<ServizioDTO>();
        Optional<Professione> professione= professioneRepository.findById(id);

        if(professione.isPresent()) {

            for (Servizio s : professione.get().getServizi()) {
                servDto.add(new ServizioDTO(s.getId(), s.getDescrizione()));
            }

        }
        return servDto;
    }

    @Override
    public List<ServizioDTO> loadAllService() {
        List<ServizioDTO> servsDto=new ArrayList<ServizioDTO>();
        List<Servizio> servs = servRepository.findAll();

            for (Servizio s : servs) {
                servsDto.add(new DozerBeanMapper().map(s, ServizioDTO.class));
            }

        return servsDto;
    }
}

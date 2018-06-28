package it.btf.service;

import it.btf.dto.ProfessioneDTO;
import it.btf.dto.ServizioDTO;
import it.btf.interf.GestioneProfessioneBE;
import it.btf.model.Professione;
import it.btf.model.Servizio;
import it.btf.repository.ProfessioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GestioneProfessioneBEService implements GestioneProfessioneBE {
    @Autowired
    ProfessioneRepository profRepository;

    @Override
    public List<ProfessioneDTO> loadAll() {
        List<ProfessioneDTO> profDto=new ArrayList<ProfessioneDTO>();
        List <Professione> professioni= profRepository.findAll();
        for(Professione p: professioni){
            profDto.add(new ProfessioneDTO(p.getId(),p.getNome(), new ArrayList<ServizioDTO>()));
        }
        return profDto;
    }

    @Override
    public List<ProfessioneDTO> loadAllWithService() {
        List<ProfessioneDTO> profDto=new ArrayList<ProfessioneDTO>();
        List <Professione> professioni= profRepository.findAll();
        for(Professione p: professioni){
            List<ServizioDTO>servDto =new ArrayList<ServizioDTO>();
            for(Servizio s: p.getServizi()){
                servDto.add(new ServizioDTO(s.getId(),s.getDescrizione()));
            }
            profDto.add(new ProfessioneDTO(p.getId(),p.getNome(),servDto));
        }
        return profDto;
    }
}

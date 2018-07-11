package it.btf.service;

import it.btf.dto.VisiteGgDTO;
import it.btf.interf.GestioneVisiteBE;
import it.btf.model.Fornitore;
import it.btf.model.Visita;
import it.btf.repository.VisiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Service
@Transactional
public class GestioneVisiteFornitoreBEService implements GestioneVisiteBE {

    @Autowired
    VisiteRepository visiteRepository;


    @Override
    public void addVisita(String email) {
        Visita visita= new Visita();
        Date dataClick = new Date();

        Fornitore forn=new Fornitore();

        forn.setEmail(email);

        visita.setDataClick(dataClick);
        visita.setFornitore(forn);

        visiteRepository.save(visita);
    }

    @Override
    public List<VisiteGgDTO> contaVisite(String email) {
        //System.err.println(email);

        List<VisiteGgDTO> values= new ArrayList<VisiteGgDTO>();

//********Istanza oggetto di tipo LocalDateTime inizializzato*****//
        LocalDateTime data = LocalDateTime.now();

//********Istanza oggetto di tipo formatter per la formattazione della data********//
        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);

//********ciclo e query sui giorni antecedenti***********//
        for(int i=0;i<7;i++){
            VisiteGgDTO visite = new VisiteGgDTO();

            LocalDateTime day=data.minusDays(i);
            String dataFormattata= formmat1.format(day);

            Long numeroVisite = visiteRepository.countByFornitore_EmailAndDataClick(email, Date.from(day.atZone(ZoneId.systemDefault()).toInstant()));
            //System.out.println(numeroVisite);
            visite.setDataStr(dataFormattata);
            visite.setNumero(numeroVisite);
            values.add(visite);
        }
        return values;
    }
}

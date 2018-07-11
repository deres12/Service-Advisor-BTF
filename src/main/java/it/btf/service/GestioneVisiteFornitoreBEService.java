package it.btf.service;

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
    VisiteRepository contatoreRepository;


    @Override
    public void addVisita(String email) {
        Visita visita= new Visita();
        Date dataClick = new Date();

        Fornitore forn=new Fornitore();

        forn.setEmail(email);

        visita.setDataClick(dataClick);
        visita.setFornitore(forn);

        contatoreRepository.save(visita);
    }

    @Override
    public Map<String,Long> contaVisite(String email) {

        Map<String,Long> values= new HashMap();

//********Istanza oggetto di tipo LocalDateTime inizializzato*****//
        LocalDateTime data = LocalDateTime.now();

//********Istanza oggetto di tipo formatter per la formattazione della data********//
        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);

//********ciclo e query sui giorni antecedenti***********//
        for(int i=0;i<7;i++){
            LocalDateTime day=data.minusDays(i);
            String formattata= formmat1.format(day);
            values.put(formattata,contatoreRepository.countByFornitore_EmailAndDataClick(email, Date.from(day.atZone(ZoneId.systemDefault()).toInstant())));
        }
        return values;
    }
}

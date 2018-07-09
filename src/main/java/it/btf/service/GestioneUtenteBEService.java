package it.btf.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.btf.dto.PersonaDTO;
import it.btf.dto.ServizioDTO;
import it.btf.interf.GestioneUtenteBE;
import it.btf.model.Cliente;
import it.btf.model.Fornitore;
import it.btf.model.Guest;
import it.btf.model.Luogo;
import it.btf.model.Professione;
import it.btf.model.Servizio;
import it.btf.repository.FornitoreRepository;
import it.btf.repository.PersonaRepository;
import it.btf.repository.ServizioRepository;
import it.btf.repository.UserRepository;
import it.btf.utility.StringHashing;

@Service
@Transactional
public class GestioneUtenteBEService implements GestioneUtenteBE {

    @Autowired
    UserRepository usersRepository;

    @Autowired
    PersonaRepository utenteRepository;

    @Autowired
    FornitoreRepository fornitoreRepository;

    @Autowired
    ServizioRepository servRep;

    /* returns true on success, false on error */
    public boolean login(String email, String password) {
        Optional<Guest> guest = usersRepository.findById(email);
        if(!guest.isPresent()) {
            return false;
        }

        /* check password hashes */
        if(!StringHashing.sha1(password).equals(guest.get().getPass())) {
            return false;
        }
        return true;
    }


    public Optional<Cliente> load(String email) {
        return utenteRepository.findById(email);
    }


    public PersonaDTO loadById(String email) {
        if (fornitoreRepository.existsById(email)) {
            Fornitore fornit = fornitoreRepository.getOne(email);
            return new PersonaDTO(fornit.getEmail(), fornit.getPass(), fornit.getNome(), fornit.getVia(), "F");
        }
        
        if (utenteRepository.existsById(email)) {
            Cliente utente = utenteRepository.getOne(email);
            return new PersonaDTO(utente.getEmail(), utente.getPass(), utente.getNome(), utente.getVia(), "C");
        } 

        return null;
    }

    /* returns 0 on success, 1 on error */
    public int addUser(PersonaDTO utente) {
        String email = utente.getEmail();

        if (usersRepository.existsById(email)) {
            return 1;
        }
            
        if (utente.getType().equalsIgnoreCase("C")) {
            this.addCliente(utente);
        } else if (utente.getType().equalsIgnoreCase("F")) {
            this.addFornitore(utente);
        }
        
        return 0;
    }


    public void addCliente(PersonaDTO utente) {
        Cliente cliente = new Cliente();
        
        cliente.setEmail(utente.getEmail());
 
        String hash = StringHashing.sha1(utente.getPass());
        cliente.setPass(hash);
        
        cliente.setNome(utente.getNome());
        
        cliente.setVia(new Luogo(utente.getVia()));

        utenteRepository.save(cliente);
    }


    public void addFornitore(PersonaDTO utente) {
        Fornitore fornitore = new Fornitore();
        
        fornitore.setEmail(utente.getEmail());
        String hash = StringHashing.sha1(utente.getPass());
        fornitore.setPass(hash);
        fornitore.setNome(utente.getNome());
        fornitore.setVia(new Luogo(utente.getVia()));

        fornitore.setDescrizione(utente.getDescrizione());
        List<Servizio> servizi = new ArrayList<Servizio>();
        if(utente.getServizi() != null){
            for (ServizioDTO s : utente.getServizi()) {
                Servizio s2 = new Servizio();
                s2.setId(s.getId());
                servizi.add(s2);
            }
        }

        fornitore.setServizi(servizi);
        Professione p = new Professione();
        p.setId(utente.getProfessione().getId());
        fornitore.setProfessione(p);
        fornitoreRepository.save(fornitore);
    }

}

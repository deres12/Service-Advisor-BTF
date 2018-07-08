package it.btf.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import it.btf.dto.LuogoDTO;
import it.btf.dto.ProfessioneDTO;
import it.btf.dto.ServizioDTO;
import it.btf.model.*;
import it.btf.repository.FornitoreRepository;
import it.btf.repository.ServizioRepository;
import it.btf.utility.DatabaseException;
import it.btf.utility.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.btf.dto.PersonaDTO;
import it.btf.interf.GestioneUtenteBE;
import it.btf.repository.PersonaRepository;
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

        if(!StringHashing.sha1(password).equals(guest.get().getPass())) {
            return false;
        }
        return true;
    }


    @Override
    public List<PersonaDTO> load(String username) {
        List<PersonaDTO> persone = new ArrayList<PersonaDTO>();

        List<Cliente> utente = utenteRepository.findByUsername(username);
        if (utente.size() == 0) {
            return persone;
        } else {
            for (Cliente a : utente) {
                LuogoDTO l=new LuogoDTO(a.getVia().getNumeroCivico(),a.getVia().getVia(),a.getVia().getPaese(),a.getVia().getNazione());
                persone.add(new PersonaDTO(a.getNome(), a.getCognome(), a.getUsername(), l, a.getEmail(), "", 0, "", "", "", null, null));
            }
        }

        return persone;
    }


    @Override
    public PersonaDTO loadById(PersonaDTO dto) {
        if (fornitoreRepository.existsById(dto.getEmail())) {
            Fornitore fornit = fornitoreRepository.getOne(dto.getEmail());
            LuogoDTO l=new LuogoDTO(fornit.getVia().getNumeroCivico(),fornit.getVia().getVia(),fornit.getVia().getPaese(),fornit.getVia().getNazione());
            return new PersonaDTO(fornit.getNome(), fornit.getCognome(), fornit.getUsername(), l, fornit.getEmail(), fornit.getPass(), fornit.getValutazione(), fornit.getNumero(), fornit.getDescrizione(), "F", null, null);
        }
        if (utenteRepository.existsById(dto.getEmail())) {
            Cliente utente = utenteRepository.getOne(dto.getEmail());
            LuogoDTO l=new LuogoDTO(utente.getVia().getNumeroCivico(),utente.getVia().getVia(),utente.getVia().getPaese(),utente.getVia().getNazione());
            return new PersonaDTO(utente.getNome(), utente.getCognome(), utente.getUsername(), l, utente.getEmail(), utente.getPass(), 0, "", "", "C", null, null);
        } else{
            return null;
        }
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
        cliente.setNome(utente.getNome());
        cliente.setCognome(utente.getCognome());
        Luogo l=new Luogo(0, "", "", "", 0.0, 0.0);
        //Luogo l=new Luogo(utente.getVia().getNumeroCivico(),utente.getVia().getVia(),utente.getVia().getPaese(),utente.getVia().getNazione(),Position.getDoubleFromAddress(utente.getVia().toString(),"lat"),Position.getDoubleFromAddress(utente.getVia().toString(),"lng"));
        cliente.setVia(l);
        cliente.setUsername(utente.getUsername());
        
        String hash = StringHashing.sha1(utente.getPass());
        cliente.setPass(hash);

        utenteRepository.save(cliente);
    }


    public void addFornitore(PersonaDTO utente) {
        Fornitore fornitore = new Fornitore();
        Luogo l=new Luogo(0, "", "", "", 0.0, 0.0);
        //Luogo l=new Luogo(utente.getVia().getNumeroCivico(),utente.getVia().getVia(),utente.getVia().getPaese(),utente.getVia().getNazione(),Position.getDoubleFromAddress(utente.getVia().toString(),"lat"),Position.getDoubleFromAddress(utente.getVia().toString(),"lng"));
        fornitore.setVia(l);
        
        String hash = StringHashing.sha1(utente.getPass());
        fornitore.setPass(hash);

        fornitore.setUsername(utente.getUsername());
        fornitore.setNome(utente.getNome());
        fornitore.setEmail(utente.getEmail());
        fornitore.setNumero(utente.getNumero());
        fornitore.setDescrizione(utente.getDescrizione());
        fornitore.setCognome(utente.getCognome());
        fornitore.setValutazione(0);
        List<Servizio> servizi = new ArrayList<Servizio>();
        if(utente.getServizi()!=null){
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

package it.btf.controller;


import it.btf.dto.RichiestaDTO;
import it.btf.dto.RispostaExampleDTO;
import it.btf.interf.GestioneRichiestaBE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/richieste")
public class GestioneRichiesteController {

//INSERISCI RICHIEST --------GET RICHIESTE EFFETTUATE-------- GET ALL RICHIESTE

    @Autowired
    GestioneRichiestaBE service;

    @ResponseBody
    @RequestMapping(value = "inserisci", method = RequestMethod.POST)
    public ResponseEntity<RispostaExampleDTO> inserisci(@RequestBody RichiestaDTO dto) {
        //System.err.println("ATTENZIONE EMAIL:  "+dto.getPersona().getEmail());
        //System.err.println(this.service.addRichiesta(dto).getId());
        this.service.addRichiesta(dto);
        return new ResponseEntity<>(new RispostaExampleDTO("Richiesta inserita "), HttpStatus.OK);
    }


    @RequestMapping("/find/{email}")
    @ResponseBody
    public List<RichiestaDTO> loadRic(@PathVariable("email") String email){

        return service.loadByEmail(email);
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<RichiestaDTO> loadAll(){

        return service.loadAll();
    }


}

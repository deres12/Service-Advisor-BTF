package it.btf.controller;


import it.btf.dto.PersonaDTO;
import it.btf.dto.RichiestaDTO;
import it.btf.dto.RispostaDTO;
import it.btf.interf.GestioneRichiestaBE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services/richieste")
public class GestioneRichiesteController {

//INSERISCI RICHIEST --------GET RICHIESTE EFFETTUATE-------- GET ALL RICHIESTE

    @Autowired
    GestioneRichiestaBE service;

    @ResponseBody
    @RequestMapping(value = "inserisci", method = RequestMethod.POST)
    public ResponseEntity<RispostaDTO> inserisci(@RequestBody RichiestaDTO dto) {

        this.service.addRichiesta(dto);

        return new ResponseEntity<>(new RispostaDTO("Richiesta inserita "), HttpStatus.OK);
    }


    @RequestMapping("/find/{email}")
    @ResponseBody
    public List<RichiestaDTO> loadRic(@PathVariable("email") String email){

        return service.loadByEmail(email);
    }
}

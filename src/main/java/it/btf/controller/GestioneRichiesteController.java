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

    @Autowired
    GestioneRichiestaBE service;

    @PostMapping("inserisci")
    public ResponseEntity<RispostaExampleDTO> inserisci(@RequestBody RichiestaDTO dto) {
        this.service.addRichiesta(dto);
        return new ResponseEntity<>(new RispostaExampleDTO("Richiesta inserita "), HttpStatus.OK);
    }


    @GetMapping("/find")
    public List<RichiestaDTO> loadRic(@RequestParam("email") String email){

        return service.loadByEmail(email);
    }

    @GetMapping("/findAll")
    public List<RichiestaDTO> loadAll(){

        return service.loadAll();
    }

}

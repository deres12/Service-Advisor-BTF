package it.btf.controller;

import it.btf.dto.VisiteGgDTO;
import it.btf.interf.GestioneVisiteBE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/conta")
public class VisiteFornitoreController {

    @Autowired
    GestioneVisiteBE gestioneVisiteBE;

    @GetMapping("/addVisita")
    public ResponseEntity aggiungiVisita(@RequestParam("email") String email) {

        gestioneVisiteBE.addVisita(email);

        return new ResponseEntity<>("Contatore aggiornato", HttpStatus.OK);

    }

    @GetMapping("/")
    public ResponseEntity<List<VisiteGgDTO>> contaVisiteFornitore(@RequestParam("email") String email) {
       List<VisiteGgDTO> conta= gestioneVisiteBE.contaVisite(email);

        return new ResponseEntity(conta, HttpStatus.OK);

    }
}

package it.btf.controller;


import it.btf.dto.OffertaDTO;
import it.btf.dto.RispostaExampleDTO;
import it.btf.interf.GestioneOfferteBE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/offerte")
public class GestioneOfferteController {

    @Autowired
    GestioneOfferteBE serviceOfferte;

    @ResponseBody
    @RequestMapping(value = "inserisci", method = RequestMethod.POST)
    public ResponseEntity<RispostaExampleDTO> inserisci(@RequestBody OffertaDTO dto) {

        this.serviceOfferte.addOfferta(dto);

        return new ResponseEntity<>(new RispostaExampleDTO("Offera inserita "), HttpStatus.OK);
    }



}

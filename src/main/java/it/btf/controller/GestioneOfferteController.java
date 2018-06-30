package it.btf.controller;


import it.btf.dto.OffertaDTO;
import it.btf.dto.RichiestaDTO;
import it.btf.dto.RispostaDTO;
import it.btf.interf.GestioneOfferteBE;
import it.btf.model.Offerta;
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
    public ResponseEntity<RispostaDTO> inserisci(@RequestBody OffertaDTO dto) {

        this.serviceOfferte.addOfferta(dto);

        return new ResponseEntity<>(new RispostaDTO("Offera inserita "), HttpStatus.OK);
    }



}

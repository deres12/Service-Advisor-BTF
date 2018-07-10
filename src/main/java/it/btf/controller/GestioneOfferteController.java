package it.btf.controller;


import it.btf.dto.OffertaDTO;
import it.btf.dto.RispostaExampleDTO;
import it.btf.interf.GestioneOfferteBE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping("/find/{id}")
    @ResponseBody
    public List<OffertaDTO> loadServiceByProf(@PathVariable("id") String id){

        return serviceOfferte.loadOfferteByFornitore(id);
    }
    @ResponseBody
    @RequestMapping(value = "findByEmail", method = RequestMethod.POST)
    public ResponseEntity<List<OffertaDTO>> ricerca (@RequestBody  String email) {

        List<OffertaDTO> response =serviceOfferte.loadOfferteByFornitore(email);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @ResponseBody
    @RequestMapping(value = "findByClient", method = RequestMethod.POST)
    public ResponseEntity<List<OffertaDTO>> ricercaPerCliente (@RequestBody  String email) {
        List<OffertaDTO> response =serviceOfferte.loadOfferteByCliente(email);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}

package it.btf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.btf.dto.FornitoreDTO;
import it.btf.dto.RicercaFornitoriDTO;
import it.btf.interf.GestioneFornitoreBE;

@RestController
@RequestMapping("/fornitore")
public class GestioneFornitoriController {

    @Autowired
    GestioneFornitoreBE gestioneFornitoreBE;

    @RequestMapping("/find")
    @ResponseBody
    public List<FornitoreDTO> loadAllFornitore(){
        return gestioneFornitoreBE.loadAllFornitore();
    }


    @RequestMapping("/find/{comune}")
    @ResponseBody
    public List<FornitoreDTO> load(@PathVariable("comune") String comune) {

        return gestioneFornitoreBE.loadAllGuestFornByComune(comune);
    }

    @ResponseBody
    @RequestMapping(value = "ricerca", method = RequestMethod.POST)
    public ResponseEntity<List<RicercaFornitoriDTO>> ricerca (@RequestBody RicercaFornitoriDTO dto) {

        List<RicercaFornitoriDTO> response =gestioneFornitoreBE.loadAllFornByDistance(dto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

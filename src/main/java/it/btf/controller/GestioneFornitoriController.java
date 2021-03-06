package it.btf.controller;

import it.btf.dto.FornitoreDTO;
import it.btf.dto.RicercaFornitoriDTO;
import it.btf.dto.RispostaExampleDTO;
import it.btf.interf.GestioneFornitoreBE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

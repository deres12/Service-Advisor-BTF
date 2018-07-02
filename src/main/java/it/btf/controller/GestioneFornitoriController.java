package it.btf.controller;

import it.btf.dto.FornitoreDTO;
import it.btf.interf.GestioneFornitoreBE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}

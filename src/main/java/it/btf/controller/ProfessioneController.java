package it.btf.controller;

import it.btf.dto.ProfessioneDTO;
import it.btf.interf.GestioneProfessioneBE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/professioni")
public class ProfessioneController {

    @Autowired
    GestioneProfessioneBE profService;

    @GetMapping("/servizi")
    public ResponseEntity<List<ProfessioneDTO>> caricaServiziProfessioni() {
        List<ProfessioneDTO> dtoProf=profService.loadAllWithService();
        return new ResponseEntity<>(dtoProf, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProfessioneDTO>> caricaProfessioni() {
        List<ProfessioneDTO> dtoProf=profService.loadAll();
        return new ResponseEntity<>(dtoProf, HttpStatus.OK);
    }

}

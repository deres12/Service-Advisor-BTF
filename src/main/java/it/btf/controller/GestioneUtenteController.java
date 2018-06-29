package it.btf.controller;


import java.util.List;


import it.btf.utility.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import it.btf.dto.PersonaDTO;
import it.btf.dto.RispostaDTO;
import it.btf.interf.GestioneUtenteBE;


@RestController
@RequestMapping("/user")
public class GestioneUtenteController {
    ///user/find
    @Autowired
    GestioneUtenteBE service;



	/*@Autowired
	GestioneServizioBE servService;*/


    @RequestMapping("/find/{username}")
    @ResponseBody

    public List<PersonaDTO> load(@PathVariable("username") String username) {

        return service.load(username);
    }

    @PostMapping("/registrati")
    @ResponseBody
    public ResponseEntity saveUser(@RequestBody PersonaDTO dto) {

        //return service.load(username);
        //service.addUser(dto);
        String a;
        try {
            a = service.addUser(dto);
        } catch (DatabaseException ex) {
            return ex.getResponse();
        }
        return ResponseEntity.ok("Utente registrato");
    }


    /*
     * COD: 1 login effettuato
     * COD: 2 email corretta password errata(o assente)
     * COD: 3 email sbagliata
     * COD: 4 email nulla, eccezione
     *
     * */
    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody PersonaDTO dto) {
        PersonaDTO loaded;
        try {
            loaded= this.service.loadById(dto);
        }catch (Exception e){
            return new ResponseEntity<>(4, HttpStatus.BAD_REQUEST);
        }

        if (loaded == null) {
            return new ResponseEntity<>(3, HttpStatus.UNAUTHORIZED);
        }
        if (!loaded.getPass().equals(dto.getPass())) {
            return new ResponseEntity<>(2, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(1, HttpStatus.OK);
    }
}
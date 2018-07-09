package it.btf.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.btf.dto.PersonaDTO;
import it.btf.interf.GestioneUtenteBE;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class GestioneUtenteController {

    @Autowired
    GestioneUtenteBE service;


    @GetMapping("/find/{email}")
    public PersonaDTO load(@PathVariable("email") String email) {
        return service.loadById(email);
    }


    @PostMapping("/registrati")
    public ResponseEntity saveUser(@RequestBody PersonaDTO dto) {
        
        int result = service.addUser(dto);
        if(result == 1) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);    
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody PersonaDTO dto) {
        
        boolean result = service.login(dto.getEmail(), dto.getPass());

        if (result == false) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        PersonaDTO user = service.loadById(dto.getEmail());
        user.setPass("");
        
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
}
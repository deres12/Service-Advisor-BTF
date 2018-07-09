package it.btf.controller;
import java.util.List;
import it.btf.utility.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import it.btf.dto.PersonaDTO;
import it.btf.interf.GestioneUtenteBE;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class GestioneUtenteController {

    @Autowired
    GestioneUtenteBE service;


    @GetMapping("/find/{username}")
    public List<PersonaDTO> load(@PathVariable("username") String username) {

        return service.load(username);
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

        PersonaDTO user = service.loadById(dto);
        user.setPass("");
        
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
}
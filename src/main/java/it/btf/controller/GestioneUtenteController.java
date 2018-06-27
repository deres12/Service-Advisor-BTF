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

import it.btf.dto.PersonaDTO;
import it.btf.dto.RispostaDTO;
import it.btf.interf.GestioneUtenteBE;
//import it.btf.security.MySecurityContext;



@RestController
@RequestMapping("/services/user")
public class GestioneUtenteController {
	///user/find
	@Autowired
	GestioneUtenteBE service;
	
	@RequestMapping("/find/{username}")
	@ResponseBody
	public List<PersonaDTO> load(@PathVariable("username") String username){

		return service.load(username);
	}
	
	@ResponseBody
	@RequestMapping(value = "inserisci", method = RequestMethod.POST)
	public ResponseEntity<RispostaDTO> inserisci(@RequestBody PersonaDTO dto) {
		this.service.addUser(dto);
		return new ResponseEntity<>(new RispostaDTO("ciao " + dto.getNome()), HttpStatus.OK);

	}
	
	/*@RequestMapping("/request/{email}")
	@ResponseBody
	public List<PersonaDTO> loadRequest(@PathVariable("email") String email){

		return service.load(email);
	}*/
	

}

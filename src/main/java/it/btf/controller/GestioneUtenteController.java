package it.btf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.btf.dto.UtenteDTO;
import it.btf.interf.GestioneUtenteBE;
import it.btf.model.User;
import it.btf.security.MySecurityContext;



@RestController
@RequestMapping("/")
public class GestioneUtenteController {
	
	@Autowired
	GestioneUtenteBE service;
	
	@RequestMapping("/{username}")
	@ResponseBody
	public UtenteDTO load(@PathVariable("username") String username){
		
		String email = MySecurityContext.getEmail();
		
		System.out.println(username);
		return service.load(username);
	}
	
	/*
	
	@RequestMapping(value="/aiuto", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> insert(@RequestBody UtenteDTO dto){
		String email = "s.carrino@yahoo.it";
		System.out.println(email);
		User a=new User();
		a.setUsername(dto.getUsername());
		a.setEmail(email);
		a.setNome(dto.getNome());
		a.setVia(dto.getVia());
		service.insert(a);
		return new ResponseEntity<String>(new String("e andato tutto bene"), HttpStatus.OK);

	}
	*/
	/*@ResponseBody
	@RequestMapping(value = "saluta", method = RequestMethod.POST)
	public ResponseEntity<RispostaDTO> saluta(@RequestBody UtenteDTO dto) {

		if (dto.getNome() != null) {
			return new ResponseEntity<RispostaDTO>(new RispostaDTO("ciao " + dto.getNome()), HttpStatus.OK);
		} else {
			return new ResponseEntity<RispostaDTO>(new RispostaDTO("utente non creato"), HttpStatus.BAD_REQUEST);
		}

	}*/

}

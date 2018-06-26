package it.btf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.btf.dto.PersonaDTO;
import it.btf.interf.GestioneUtenteBE;
import it.btf.security.MySecurityContext;



@RestController
@RequestMapping("/user")
public class GestioneUtenteController {
	
	@Autowired
	GestioneUtenteBE service;
	
	@RequestMapping("/{username}")
	@ResponseBody
	public PersonaDTO load(@PathVariable("username") String username){
		
		//String email = MySecurityContext.getEmail();
		
		System.out.println(username);
		return service.load(username);
	}
	

}

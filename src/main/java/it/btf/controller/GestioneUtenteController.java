package it.btf.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import it.btf.dto.PersonaDTO;
import it.btf.dto.RispostaDTO;
import it.btf.interf.GestioneUtenteBE;



@RestController
@RequestMapping("/services/user")
public class GestioneUtenteController {
	///user/find
	@Autowired
	GestioneUtenteBE service;



	/*@Autowired
	GestioneServizioBE servService;*/



	@RequestMapping("/find/{username}")
	@ResponseBody

	public List<PersonaDTO> load(@PathVariable("username") String username){

		return service.load(username);
	}

	@PostMapping("/registrati")
	@ResponseBody
	public ResponseEntity<RispostaDTO> saveUser(@RequestBody PersonaDTO dto){

		//return service.load(username);
		//service.addUser(dto);

		String a=service.addUser(dto);
		return new ResponseEntity<>(new RispostaDTO("ciao Cliente, il risultato e: " + a), HttpStatus.OK);
	}




	/*@ResponseBody
	@RequestMapping(value = "inserimento", method = RequestMethod.POST)
	public ResponseEntity<RispostaDTO> inserisci(@RequestBody PersonaDTO dto) {
		this.service.addUser(dto);
		return new ResponseEntity<>(new RispostaDTO("ciao " + dto.getNome()), HttpStatus.OK);

	}*/

	@ResponseBody
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ResponseEntity<RispostaDTO> login(@RequestBody PersonaDTO dto) {
		PersonaDTO loaded=this.service.loadById(dto);
		if (loaded!=null){
			if(loaded.getEmail().equals(dto.getEmail())&&loaded.getPass().equals(dto.getPass()))
				return new ResponseEntity<>(new RispostaDTO("ciao Cliente: " + loaded.getNome()), HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.PARTIAL_CONTENT);
		}else
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);


	}


}

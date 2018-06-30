package it.btf.controller;


import it.btf.dto.ServizioDTO;
import it.btf.interf.GestioneServiziBE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/services/servizi")
public class GestioneServiziController {

    @Autowired
    GestioneServiziBE service;

    @RequestMapping("/find/{professione}")
    @ResponseBody
    public List<ServizioDTO> loadServiceByProf(@PathVariable("professione") String professione){

        return service.loadServiceByProf(professione);
    }

}

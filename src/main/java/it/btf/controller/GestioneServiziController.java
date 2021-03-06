package it.btf.controller;


import it.btf.dto.ServizioDTO;
import it.btf.interf.GestioneServiziBE;
import it.btf.interf.GestioneServizioBE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/servizi")
public class GestioneServiziController {

    @Autowired
    GestioneServizioBE service;

    @RequestMapping("/find/{id}")
    @ResponseBody
    public List<ServizioDTO> loadServiceByProf(@PathVariable("id") Long id){

        return service.loadAllByProf(id);
    }

    @RequestMapping("/find")
    @ResponseBody
    public List<ServizioDTO> loadServiceByProf(){

        return service.loadAllService();
    }
}

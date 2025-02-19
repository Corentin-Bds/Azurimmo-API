package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Contrat;
import bts.sio.azurimmo.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
public class ContratController {

    @Autowired
    private ContratService contratService;

    //Récupération des contrats
    @GetMapping("")
    public List<Contrat> getAllContrats(){
        return contratService.getAllContrats();
    }

    @GetMapping("/{id}")
    public Contrat getContratById(@PathVariable Long id){
        return contratService.getContratById(id);
    }
}

package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Contrat;
import bts.sio.azurimmo.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:3000"}, methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE,
        RequestMethod.OPTIONS,
        RequestMethod.PATCH
})
public class ContratController {

    @Autowired
    private ContratService contratService;

    //Récupération des contrats
    @GetMapping("")
    public List<Contrat> getAllContrats() {
        return contratService.getAllContrats();
    }

    @GetMapping("/{id}")
    public Contrat getContratById(@PathVariable Long id) {
        return contratService.getContratById(id);
    }

    @GetMapping("/appartement/{id}")
    public Contrat getContratByAppartementId(@PathVariable Long id) {
        return contratService.getContratByAppartementId(id);
    }
}

package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Contrat;
import bts.sio.azurimmo.repository.ContratRepository;
import bts.sio.azurimmo.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private ContratRepository contratRepository;

    //Récupération des contrats
    @GetMapping("")
    public List<Contrat> getAllContrats() {
        return contratService.getAllContrats();
    }

    @GetMapping("/{id}")
    public Contrat getContratById(@PathVariable Long id) {
        return contratService.getContratById(id);
    }

    @PostMapping("")
    public Contrat createContrat(@RequestBody Contrat contrat) {
        return contratService.saveContrat(contrat);
    }

    @GetMapping("/appartement/{id}")
    public Contrat getContratByAppartementId(@PathVariable Long id) {
        return contratService.getContratByAppartementId(id);
    }

    @DeleteMapping("/locataire/{locataireId}")
    public ResponseEntity<?> deleteContratsByLocataire(@PathVariable Long locataireId) {
        List<Contrat> contrats = contratRepository.findAllByLocataireId(locataireId);
        if (!contrats.isEmpty()) {
            contratRepository.deleteAll(contrats);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(404).body("Aucun contrat trouvé pour ce locataire.");
        }
    }
}

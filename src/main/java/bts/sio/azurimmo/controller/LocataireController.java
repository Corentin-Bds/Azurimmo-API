package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Locataire;
import bts.sio.azurimmo.service.LocataireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/locataires")
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:3000"}, methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE,
        RequestMethod.OPTIONS,
        RequestMethod.PATCH
})
public class LocataireController {

    @Autowired
    private LocataireService locataireService;

    // lister tous les locataires
    @GetMapping("")
    public List<Locataire> getAllLocataires() {
        return locataireService.getAllLocataires();
    }

    // Récupérer un locataire par son ID
    @GetMapping("/{id}")
    public Locataire getLocataireById(@PathVariable Long id) {
        return locataireService.getLocataireById(id);
    }

    // Ajouter un locataire
    @PostMapping("")
    public Locataire createLocataire(@RequestBody Locataire locataire) {
        return locataireService.saveLocataire(locataire);
    }

    // Modifier un locataire
    @PutMapping("/{id}")
    public Locataire updateLocataire(@PathVariable Long id, @RequestBody Locataire locataire) {
        locataire.setId(id);
        return locataireService.saveLocataire(locataire);
    }

    // Supprimer un locataire
    @DeleteMapping("/{id}")
    public boolean deleteLocataire(@PathVariable Long id) {
        return locataireService.deleteLocataire(id);
    }
}

package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.service.AppartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appartements")
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:3000"}, methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE,
        RequestMethod.OPTIONS,
        RequestMethod.PATCH
})
public class AppartementController {

    @Autowired
    private AppartementService appartementService;

    @GetMapping("/batiment/{batimentId}")
    public List<Appartement> getAppartementsByBatiment(@PathVariable int batimentId) {
        return appartementService.getAppartementsByBatimentId(batimentId);
    }

    @GetMapping("")
    public List<Appartement> getAllAppartements() {
        return appartementService.getAllAppartements();
    }

    // Ajout de l'endpoint avec slash pour compatibilité
    @GetMapping("/")
    public List<Appartement> getAllAppartementsWithSlash() {
        return appartementService.getAllAppartements();
    }

    @GetMapping("/{id}")
    public Appartement getAppartementById(@PathVariable Long id) {
        return appartementService.getAppartementById(id);
    }

    @PostMapping("/")
    public Appartement createAppartement(@RequestBody Appartement appartement) {
        return appartementService.saveAppartement(appartement);
    }

    @PutMapping("/{id}")
    public Appartement updateAppartement(@PathVariable Long id, @RequestBody Appartement appartement) {
        appartement.setId(id);
        return appartementService.saveAppartement(appartement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppartement(@PathVariable Long id) {
        try {
            boolean deleted = appartementService.deleteAppartement(id);
            if (deleted) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(404).body("Appartement introuvable.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erreur lors de la suppression : " + e.getMessage());
        }
    }

    @GetMapping("/ville/{ville}")
    public List<Appartement> findByVille(@PathVariable String ville) {
        return appartementService.findByVille(ville);
    }
}
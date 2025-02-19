package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.service.AppartementService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appartements")
public class AppartementController {

    @Autowired
    private AppartementService appartementService;

    @GetMapping("/batiment/{batimentId}")
    public List<Appartement> getAppartementsByBatiment(@PathVariable int batimentId) {
        return appartementService.getAppartementsByBatimentId(batimentId);
    }

    @GetMapping("")
    public List<Appartement> getAllAppartements(){
        return appartementService.getAllAppartements();
    }

    @PostMapping("/")
    public Appartement createAppartement(@RequestBody Appartement appartement) {
        return appartementService.saveAppartement(appartement);
    }

    @GetMapping("/ville/{ville}")
    public List<Appartement> findByVille(@PathVariable String ville) {
        return appartementService.findByVille(ville);
    }
}
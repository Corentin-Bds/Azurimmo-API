package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.model.Batiment;
import bts.sio.azurimmo.repository.BatimentRepository;
import bts.sio.azurimmo.service.BatimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/batiments")
public class BatimentController {

    @Autowired
    private BatimentService batimentService;

    // 📌 Récupérer tous les bâtiments
    @GetMapping("/")
    public List<Batiment> getAllBatiments() {
        return batimentService.getAllBatiments();
    }

    @PostMapping("/")
    public Batiment createBatiment(@RequestBody Batiment batiment) {
        return batimentService.saveBatiment(batiment);
    }

    // 📌 Récupérer un bâtiment spécifique par ID
    @GetMapping("/id/{batimentId}")
    public Batiment getBatiment(@PathVariable int batimentId) {
        return batimentService.getBatiment(batimentId);
    }
}

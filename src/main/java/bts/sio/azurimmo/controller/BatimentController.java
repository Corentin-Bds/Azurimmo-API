package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Batiment;
import bts.sio.azurimmo.service.BatimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batiments")
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:3000"}, methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE,
        RequestMethod.OPTIONS,
        RequestMethod.PATCH
})
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

    @PutMapping("/{batimentId}")
    public Batiment updateBatiment(@PathVariable Long batimentId, @RequestBody Batiment batiment) {
        batiment.setId(batimentId);
        return batimentService.saveBatiment(batiment);
    }

    @DeleteMapping("/{batimentId}")
    public ResponseEntity<Boolean> deleteBatiment(@PathVariable int batimentId) {
        return ResponseEntity.ok(batimentService.deleteBatiment(batimentId));
    }
}

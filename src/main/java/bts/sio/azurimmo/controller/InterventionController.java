package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Intervention;
import bts.sio.azurimmo.service.InterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interventions")
public class InterventionController {

        @Autowired
        private InterventionService interventionService;

        // Lister toutes les interventions
        @GetMapping("")
        public List<Intervention> getAllInterventions() {
            return interventionService.getAllInterventions();
        }

        // Consulter une intervention spécifique
        @GetMapping("/{id}")
        public ResponseEntity<Intervention> getInterventionById(@PathVariable Long id) {
            return interventionService.getInterventionById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        // Modifier une intervention
        @PutMapping("/{id}")
        public ResponseEntity<Intervention> updateIntervention(
                @PathVariable Long id,
                @RequestBody Intervention updatedIntervention) {
            try {
                Intervention intervention = interventionService.updateIntervention(id, updatedIntervention);
                return ResponseEntity.ok(intervention);
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }
        }
}

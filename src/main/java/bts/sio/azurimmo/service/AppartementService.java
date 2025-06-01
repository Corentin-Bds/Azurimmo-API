package bts.sio.azurimmo.service;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.model.Contrat;
import bts.sio.azurimmo.repository.AppartementRepository;
import bts.sio.azurimmo.repository.ContratRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class AppartementService {
    @Autowired
    private AppartementRepository appartementRepository;

    @Autowired
    private ContratRepository contratRepository;

    public List<Appartement> getAllAppartements() {
        return appartementRepository.findAll();
    }

    public Appartement getAppartementById(Long id) {
        Optional<Appartement> appartement = appartementRepository.findById(id);
        return appartement.orElse(null);
    }

    public Appartement saveAppartement(Appartement appartement) {
        if (appartement.getId() != null && appartement.getId() == 0) {
            appartement.setId(null);
        }
        return appartementRepository.save(appartement);
    }

    public boolean deleteAppartement(Long id) {
        Optional<Appartement> appartement = appartementRepository.findById(id);
        if (appartement.isPresent()) {
            // CORRECTION : Supprimer d'abord tous les contrats liés à cet appartement
            List<Contrat> contratsLies = contratRepository.findByAppartementId(id);
            if (!contratsLies.isEmpty()) {
                contratRepository.deleteAll(contratsLies);
            }

            // Ensuite supprimer l'appartement
            appartementRepository.delete(appartement.get());
            return true;
        }
        return false;
    }

    public List<Appartement> findByVille(String ville) {
        return appartementRepository.findByBatiment_Ville(ville);
    }

    public List<Appartement> getAppartementsByBatimentId(int batimentId) {
        return appartementRepository.findByBatimentId(batimentId);
    }
}
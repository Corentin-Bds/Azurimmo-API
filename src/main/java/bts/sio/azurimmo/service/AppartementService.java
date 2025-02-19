package bts.sio.azurimmo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.repository.AppartementRepository;
import lombok.Data;

@Data
@Service
public class AppartementService {
    @Autowired
    private AppartementRepository appartementRepository;

    public List<Appartement> getAllAppartements(){
        return appartementRepository.findAll();
    }

    public Appartement saveAppartement(Appartement appartement) {
        if (appartement.getId() == 0) {
        appartement.setId(null);
        }
        return appartementRepository.save(appartement);
    }

    public List<Appartement> findByVille(String ville) {
        return appartementRepository.findByBatiment_Ville(ville);
    }

    public List<Appartement> getAppartementsByBatimentId(int batimentId) {
        return appartementRepository.findByBatimentId(batimentId);
    }
}
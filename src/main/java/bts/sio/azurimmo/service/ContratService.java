package bts.sio.azurimmo.service;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.model.Contrat;
import bts.sio.azurimmo.model.Document;
import bts.sio.azurimmo.repository.AppartementRepository;
import bts.sio.azurimmo.repository.ContratRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class ContratService {

    @Autowired
    private ContratRepository contratRepository;

    @Autowired
    private AppartementRepository appartementRepository;

    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }

    public Contrat getContratById(Long id) {
        Optional<Contrat> contrat = contratRepository.findById(id);
        return contrat.orElse(null);
    }

    public Contrat getContratByAppartementId(Long appartementId) {
        List<Contrat> contrats = contratRepository.findByAppartementId(appartementId);
        if (!contrats.isEmpty()) {
            return contrats.get(0); // ou le plus récent selon la logique métier
        }
        return null;
    }

    public Contrat saveContrat(Contrat contrat) {
        if (contrat.getId() != null && contrat.getId() == 0) {
            contrat.setId(null);
        }

        // S'assurer que l'appartement est bien lié
        if (contrat.getAppartement() != null && contrat.getAppartement().getId() != null) {
            Optional<Appartement> appartement = appartementRepository.findById(contrat.getAppartement().getId());
            appartement.ifPresent(contrat::setAppartement);
        }

        return contratRepository.save(contrat);
    }

    public boolean deleteContrat(Long id) {
        Optional<Contrat> contrat = contratRepository.findById(id);
        if (contrat.isPresent()) {
            contratRepository.delete(contrat.get());
            return true;
        }
        return false;
    }
}
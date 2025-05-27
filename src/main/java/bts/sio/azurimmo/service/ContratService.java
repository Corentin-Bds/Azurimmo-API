package bts.sio.azurimmo.service;

import bts.sio.azurimmo.model.Contrat;
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
}

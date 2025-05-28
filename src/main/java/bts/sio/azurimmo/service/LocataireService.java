package bts.sio.azurimmo.service;

import bts.sio.azurimmo.model.Locataire;
import bts.sio.azurimmo.repository.LocataireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocataireService {

    @Autowired
    private LocataireRepository locataireRepository;

    // Récupérer tous les locataires
    public List<Locataire> getAllLocataires() {
        return locataireRepository.findAll();
    }

    // Récupérer un locataire par son ID
    public Locataire getLocataireById(Long id) {
        Optional<Locataire> locataire = locataireRepository.findById(id);
        return locataire.orElse(null);
    }

    // Ajouter et modifier un locataire

    public Locataire saveLocataire(Locataire locataire) {
        if (locataire.getId() != null && locataire.getId() == 0) {
            locataire.setId(null);
        }
        return locataireRepository.save(locataire);
    }

    // Supprimer un locataire

    public boolean deleteLocataire(Long id) {
        if (locataireRepository.existsById(id)) {
            locataireRepository.deleteById(id); // suppression en cascade automatique
            return true;
        }
        return false;
    }
}

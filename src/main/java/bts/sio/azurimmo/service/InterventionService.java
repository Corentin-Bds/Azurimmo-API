package bts.sio.azurimmo.service;

import bts.sio.azurimmo.model.Intervenant;
import bts.sio.azurimmo.model.Intervention;
import bts.sio.azurimmo.repository.InterventionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterventionService {

   @Autowired
   private InterventionRepository interventionRepository;

   //Lister les interventions
    public List<Intervention> getAllInterventions(){
        return interventionRepository.findAll();
    }

    //Consulter intervention spécifique
    public Optional<Intervention> getInterventionById(Long id){
        return interventionRepository.findById(id);
    }

    //Modifier intervention
    public Intervention updateIntervention (Long id, Intervention updatedIntervention){
        return interventionRepository.findById(id).map(intervention -> {
            intervention.setDate(updatedIntervention.getDate());
            intervention.setDescription(updatedIntervention.getDescription());
            intervention.setAppartement(updatedIntervention.getAppartement());
            intervention.setIntervenant(updatedIntervention.getIntervenant());
            return interventionRepository.save(intervention);
        }).orElseThrow(() -> new RuntimeException("Intervention non trouvée avec l'ID : "+ id));
    }
}

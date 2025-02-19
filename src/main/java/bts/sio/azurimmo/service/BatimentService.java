package bts.sio.azurimmo.service;

import bts.sio.azurimmo.model.Batiment;
import bts.sio.azurimmo.repository.BatimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatimentService {

    @Autowired
    private BatimentRepository batimentRepository;

    public List<Batiment> getAllBatiments() {
        return batimentRepository.findAll();
    }

    public Batiment getBatiment(int batimentId) {
        Optional<Batiment> batiment = batimentRepository.findById(batimentId);
        return batiment.orElse(null);
    }

    public Batiment saveBatiment(Batiment batiment) {
        if (batiment.getId() == 0) {
            batiment.setId(null);
        }
        return batimentRepository.save(batiment);
    }
}
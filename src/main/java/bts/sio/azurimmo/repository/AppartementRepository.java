package bts.sio.azurimmo.repository;

import bts.sio.azurimmo.model.Appartement;
import org.springframework.stereotype.Repository;
import bts.sio.azurimmo.model.Batiment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface AppartementRepository extends JpaRepository<Appartement, Long> {
    List<Appartement> findByBatiment_Ville(String ville);
    List<Appartement> findByBatimentId(int batimentId);
}
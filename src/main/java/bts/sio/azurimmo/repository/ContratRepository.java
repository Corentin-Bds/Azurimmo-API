package bts.sio.azurimmo.repository;

import bts.sio.azurimmo.model.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
    List<Contrat> findByAppartementId(Long appartementId);

    List<Contrat> findAllByLocataireId(Long locataireId);
}

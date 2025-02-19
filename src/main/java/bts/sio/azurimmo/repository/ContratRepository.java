package bts.sio.azurimmo.repository;

import bts.sio.azurimmo.model.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
}

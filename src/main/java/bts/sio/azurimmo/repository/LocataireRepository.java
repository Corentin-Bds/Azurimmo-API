package bts.sio.azurimmo.repository;

import bts.sio.azurimmo.model.Locataire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocataireRepository extends JpaRepository<Locataire, Long> {
}

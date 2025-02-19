package bts.sio.azurimmo.repository;

import bts.sio.azurimmo.model.Intervention;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface InterventionRepository extends JpaRepository<Intervention, Long>{

}

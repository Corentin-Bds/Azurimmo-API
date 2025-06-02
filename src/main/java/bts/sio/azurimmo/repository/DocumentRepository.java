package bts.sio.azurimmo.repository;

import bts.sio.azurimmo.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByContratId(Long contratId);
}
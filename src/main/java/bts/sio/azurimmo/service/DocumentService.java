package bts.sio.azurimmo.service;

import bts.sio.azurimmo.model.Document;
import bts.sio.azurimmo.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    // Récupérer tous les documents
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    // Récupérer un document par son ID
    public Document getDocumentById(Long id) {
        Optional<Document> document = documentRepository.findById(id);
        return document.orElse(null);
    }

    // Ajouter ou modifier un document
    public Document saveDocument(Document document) {
        if (document.getId() != null && document.getId() == 0) {
            document.setId(null);
        }
        return documentRepository.save(document);
    }

    // Supprimer un document
    public boolean deleteDocument(Long id) {
        if (documentRepository.existsById(id)) {
            documentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Récupérer tous les documents d'un contrat
    public List<Document> getDocumentsByContratId(Long contratId) {
        return documentRepository.findByContratId(contratId);
    }
}
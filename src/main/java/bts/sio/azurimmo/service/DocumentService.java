package bts.sio.azurimmo.service;

import bts.sio.azurimmo.model.Document;
import bts.sio.azurimmo.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    // Récupérer tous les documents d'un contrat
    public List<Document> getDocumentsByContratId(Long contratId) {
        return documentRepository.findByContratId(contratId);
    }
}
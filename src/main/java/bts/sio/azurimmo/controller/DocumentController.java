package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Document;
import bts.sio.azurimmo.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:3000"}, methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE,
        RequestMethod.OPTIONS,
        RequestMethod.PATCH
})
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/")
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @GetMapping("/{id}")
    public Document getDocumentById(@PathVariable Long id) {
        return documentService.getDocumentById(id);
    }

    @PostMapping("/")
    public Document createDocument(@RequestBody Document document) {
        return documentService.saveDocument(document);
    }

    @PutMapping("/{id}")
    public Document updateDocument(@PathVariable Long id, @RequestBody Document document) {
        document.setId(id);
        return documentService.saveDocument(document);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDocument(@PathVariable Long id) {
        boolean deleted = documentService.deleteDocument(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(404).body("Document introuvable.");
    }

    @GetMapping("/contrat/{contratId}")
    public List<Document> getDocumentsByContrat(@PathVariable Long contratId) {
        return documentService.getDocumentsByContratId(contratId);
    }
}

package bts.sio.azurimmo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "contrat")
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = ("montant_loyer"))
    private Float montantLoyer;

    @Column(name = ("montant_charges"))
    private Float montantCharges;

    @Column(name = ("date_debut"))
    private Date dateDebut;

    @Column(name = ("date_fin"))
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = ("appartement_id"))
    private Appartement appartement;

    @ManyToOne
    @JoinColumn(name = "locataire_id")
    private Locataire locataire;

    // ✅ CHANGEZ JUSTE CETTE LIGNE (supprimez mappedBy = "document")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contrat_id") // Indique que la colonne contrat_id est dans la table documents
    private List<Document> documents;

    // Tous vos getters/setters restent identiques...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMontantLoyer() {
        return montantLoyer;
    }

    public void setMontantLoyer(Float montantLoyer) {
        this.montantLoyer = montantLoyer;
    }

    public Float getMontantCharges() {
        return montantCharges;
    }

    public void setMontantCharges(Float montantCharges) {
        this.montantCharges = montantCharges;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Appartement getAppartement() {
        return appartement;
    }

    public void setAppartement(Appartement appartement) {
        this.appartement = appartement;
    }

    public Locataire getLocataire() {
        return locataire;
    }

    public void setLocataire(Locataire locataire) {
        this.locataire = locataire;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
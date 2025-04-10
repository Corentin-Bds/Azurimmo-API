package bts.sio.azurimmo.model;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "appartement")
public class Appartement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name=("numero"))
    private Long numero;

    @Column(name=("surface"))
    private Float surface;

    @Column(name=("nbrPiece"))
    private Long nbrPiece;

    @Column(name="description")
    private String description;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "batiment_id")
    private Batiment batiment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Float getSurface() {
        return surface;
    }

    public void setSurface(Float surface) {
        this.surface = surface;
    }

    public Long getNbrPiece() {
        return nbrPiece;
    }

    public void setNbrPiece(Long nbrPiece) {
        this.nbrPiece = nbrPiece;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Batiment getBatiment() {
        return batiment;
    }

    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }

}

package bts.sio.azurimmo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;

@Data
@Entity
@Table(name = "intervention")
public class Intervention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name=("date"))
    private Date date;

    @Column(name=("description"))
    private String description;

    @ManyToOne
    @JoinColumn(name = "appartement_id")
    private Appartement appartement;



    @ManyToOne
    @JoinColumn(name = "intervenant_id")
    private Intervenant intervenant;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Appartement getAppartement() {
        return appartement;
    }

    public void setAppartement(Appartement appartement) {
        this.appartement = appartement;
    }

    public Intervenant getIntervenant() {
        return intervenant;
    }

    public void setIntervenant(Intervenant intervenant) {
        this.intervenant = intervenant;
    }
}
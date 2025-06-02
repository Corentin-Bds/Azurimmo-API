package bts.sio.azurimmo.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "type_documents")
public class TypeDocument {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nom;
}

package evaluation.example.evaluation.model;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Critere {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nom;

    public Critere(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Critere() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}



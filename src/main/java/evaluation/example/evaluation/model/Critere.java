package evaluation.example.evaluation.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Critere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evaluation> evaluations;

    public Critere(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Critere() {

    }

    public List<Evaluation> getEvaluations() {
        return this.evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
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

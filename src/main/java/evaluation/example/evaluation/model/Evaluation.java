package evaluation.example.evaluation.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "critere_id")
    private Critere critere;

    private int note;


    public Evaluation(Long id, Critere critere, int note) {
        this.id = id;
        this.critere = critere;
        this.note = note;
    }

    public Evaluation() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Critere getCritere() {
        return critere;
    }

    public void setCritere(Critere critere) {
        this.critere = critere;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}

package evaluation.example.evaluation.repositories;

import evaluation.example.evaluation.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long>{
}

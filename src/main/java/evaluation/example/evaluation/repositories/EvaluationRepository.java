package evaluation.example.evaluation.repositories;

import evaluation.example.evaluation.model.Evaluation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long>{
    List<Evaluation> findAllByCritereId(Long id);
}

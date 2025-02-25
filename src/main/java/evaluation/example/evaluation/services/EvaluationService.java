package evaluation.example.evaluation.services;

import evaluation.example.evaluation.model.Evaluation;
import evaluation.example.evaluation.repositories.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationService {
    @Autowired
    private EvaluationRepository evaluationRepository;

    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }

    public Evaluation getEvaluationById(Long id) {
        Optional<Evaluation> evaluation = evaluationRepository.findById(id);
        return evaluation.orElse(null);
    }

    public Evaluation createEvaluation(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    public Evaluation updateEvaluation(Long id, Evaluation evaluationDetails) {
        Evaluation evaluation = getEvaluationById(id);
        if (evaluation != null) {
            evaluation.setNote(evaluationDetails.getNote());
            evaluation.setCritere(evaluationDetails.getCritere());
            return evaluationRepository.save(evaluation);
        }
        return null;
    }

    public void deleteEvaluation(Long id) {
        evaluationRepository.deleteById(id);
    }
}

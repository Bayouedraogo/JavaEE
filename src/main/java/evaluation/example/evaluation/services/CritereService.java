package evaluation.example.evaluation.services;

import evaluation.example.evaluation.model.Critere;
import evaluation.example.evaluation.model.Evaluation;
import evaluation.example.evaluation.repositories.CritereRepository;
import evaluation.example.evaluation.repositories.EvaluationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CritereService {

    @Autowired
    private CritereRepository critereRepository;

    @Autowired
    private EvaluationRepository evaluationRepository;

    public List<Critere> getAllCriteres() {
        return critereRepository.findAll();
    }

    public Critere getCritereById(Long id) {
        Optional<Critere> critere = critereRepository.findById(id);
        return critere.orElse(null);
    }

    public Critere createCritere(Critere critere) {
        return critereRepository.save(critere);
    }

    public Critere updateCritere(Long id, Critere critereDetails) {
        Critere critere = getCritereById(id);
        if (critere != null) {
            critere.setNom(critereDetails.getNom());
            return critereRepository.save(critere);
        }
        return null;
    }

    public void deleteCritere(Long id) {
        List<Evaluation> evaluations = evaluationRepository.findAllByCritereId(id);
        // Critere critere = critereRepository.findById(id)
        //         .orElseThrow(() -> new RuntimeException("Critère introuvable"));
        evaluationRepository.deleteAll(evaluations);
        critereRepository.deleteById(id);
    }
}

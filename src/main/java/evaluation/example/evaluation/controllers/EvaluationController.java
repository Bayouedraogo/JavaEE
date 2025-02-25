package evaluation.example.evaluation.controllers;

import evaluation.example.evaluation.model.Critere;
import evaluation.example.evaluation.model.Evaluation;
import evaluation.example.evaluation.services.CritereService;
import evaluation.example.evaluation.services.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/evaluations")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    private CritereService critereService;

    @GetMapping("/submit")
    public String showSubmitEvaluationForm(Model model) {
        model.addAttribute("evaluation", new Evaluation());
        List<Critere> criteres = critereService.getAllCriteres();
        model.addAttribute("criteres", criteres);
        return "soumettreEvaluation"; // Retourne la vue "soumettreEvaluation.html"
    }

    @PostMapping("/submit")
    public String submitEvaluation(Evaluation evaluation) {
        evaluationService.createEvaluation(evaluation);
        return "redirect:/evaluations/succes";
    }

    @GetMapping("/historique")
    public String listEvaluations(Model model) {
        List<Evaluation> evaluations = evaluationService.getAllEvaluations();
        model.addAttribute("evaluations", evaluations);
        return "historiqueEvaluations"; // Retourne la vue "historiqueEvaluations.html"
    }

    @GetMapping("/moyennes")
    public String showAverageRatings(Model model) {
        List<Evaluation> evaluations = evaluationService.getAllEvaluations();
        Map<Critere, Double> moyennes = evaluations.stream()
                .collect(Collectors.groupingBy(Evaluation::getCritere,
                        Collectors.averagingDouble(Evaluation::getNote)));
        model.addAttribute("moyennes", moyennes);
        return "moyennesNotes"; // Retourne la vue "moyennesNotes.html"
    }
}

package evaluation.example.evaluation.controllers;

import evaluation.example.evaluation.model.Critere;
import evaluation.example.evaluation.services.CritereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/criteres")
public class CritereController {

    @Autowired
    private CritereService critereService;

    public CritereController(CritereService critereService) {
        this.critereService = critereService;
    }

    @GetMapping
    public String listCriteres(Model model) {
        List<Critere> criteres = critereService.getAllCriteres();
        model.addAttribute("criteres", criteres);
        return "criteres"; // Retourne la vue "criteres.html"
    }

    @GetMapping("/new")
    public String showNewCritereForm(Model model) {
        model.addAttribute("critere", new Critere());
        return "newCritere"; // Retourne la vue "newCritere.html"
    }

    @PostMapping("/new")
    public String createCritere(@ModelAttribute Critere critere) {
        critereService.createCritere(critere);
        return "redirect:/criteres";
    }


    @GetMapping("/edit/{id}")
    public String showEditCritereForm(Model model, @PathVariable Long id) {
        Critere critere = critereService.getCritereById(id);
        model.addAttribute("critere", critere);
        return "editCritere"; // Retourne la vue "editCritere.html"
    }

    @PostMapping("/edit/{id}")
    public String updateCritere(@PathVariable Long id, Critere critereDetails) {
        critereService.updateCritere(id, critereDetails);
        return "redirect:/criteres";
    }

    @GetMapping("/delete/{id}")
    public String deleteCritere(@PathVariable Long id) {
        critereService.deleteCritere(id);
        return "redirect:/criteres";
    }
}



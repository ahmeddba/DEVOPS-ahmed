package tn.esprit.foyeruniversiteeya.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import tn.esprit.foyeruniversiteeya.entities.Projet;
import tn.esprit.foyeruniversiteeya.services.IProjetService;
import tn.esprit.foyeruniversiteeya.services.IProjetService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Projet")
public class ProjetController {
    IProjetService projetService;
    @PostMapping("/addProjet")
    Projet addProjet(@RequestBody Projet projet){
        return projetService.addProjet(projet);
    }
    @GetMapping("/Projet/{id}")
    Projet retrieveProjet(@PathVariable Long id){
        return projetService.getProjet(id);
    }
    @GetMapping("/Projet")
    List<Projet> retrieveProjet(){
        return projetService.getAllProjet();
    }
    @DeleteMapping("/Projet/{id}")
    void deleteProjet(@PathVariable Long id){
        projetService.deleteProjet(id);
    }
    @PutMapping("/updateProjet")
    Projet updateProjet(@RequestBody Projet projet){
        return projetService.updateProjet(projet);
    }
}

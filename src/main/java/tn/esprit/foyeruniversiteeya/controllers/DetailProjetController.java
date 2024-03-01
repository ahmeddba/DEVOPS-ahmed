package tn.esprit.foyeruniversiteeya.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tn.esprit.foyeruniversiteeya.repositories.DetailProjetRepository;
import tn.esprit.foyeruniversiteeya.services.IDetailProjetService;
import tn.esprit.foyeruniversiteeya.entities.DetailProjet;
import tn.esprit.foyeruniversiteeya.services.IProjetService;

import java.util.List;

@RestController
@AllArgsConstructor
public class DetailProjetController {
    IDetailProjetService detailprojetService;

    @PostMapping("/addDetailProjet")
    DetailProjet addDetailProjet(@RequestBody DetailProjet detailprojet){
        return detailprojetService.addDetailProjet(detailprojet);
    }
    @GetMapping("/DetailProjet/{id}")
    DetailProjet retrieveDetailProjet(@PathVariable Long id){
        return detailprojetService.getDetailProjet(id);
    }
    @GetMapping("/DetailProjet")
    List<DetailProjet> retrieveDetailProjet(){
        return detailprojetService.getAllDetailProjet();
    }
    @DeleteMapping("/DetailProjet/{id}")
    void deleteDetailProjet(@PathVariable Long id){
        detailprojetService.deleteDetailProjet(id);
    }
    @PutMapping("/updateDetailProjet")
    DetailProjet updateDetailProjet(@RequestBody DetailProjet detailprojet){
        return detailprojetService.updateDetailProjet(detailprojet);
    }
}

package tn.esprit.foyeruniversiteeya.services;
import org.springframework.stereotype.Service;
import tn.esprit.foyeruniversiteeya.entities.Projet;


import java.util.List;

public interface IProjetService  {
    Projet addProjet(Projet Projet);
    List<Projet> getAllProjet();
    Projet getProjet(Long idProjet);
    void deleteProjet(Long idProjet);
    Projet updateProjet(Projet projet);
}

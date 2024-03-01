package tn.esprit.foyeruniversiteeya.services;


import tn.esprit.foyeruniversiteeya.entities.Foyer;
import tn.esprit.foyeruniversiteeya.entities.Ville;

import java.util.List;

public interface IVilleService {

    Ville addVille(Ville ville);
    List<Ville> getAllVilless();
    Ville getVile(Long idVille);
    void deleteVille(Long idVille);
    Ville updateVille(Ville ville) throws Exception;

}

package tn.esprit.foyeruniversiteeya.services;

import tn.esprit.foyeruniversiteeya.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer addFoyer(Foyer foyer);
    List<Foyer> getAllFoyers();
    Foyer getFoyer(Long idFoyer);
    void deleteFoyer(Long idFoyer);


   // Foyer updateFoyer(Long id, Foyer foyer);
   Foyer updateFoyer(Foyer foyer);
}

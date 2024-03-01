package tn.esprit.foyeruniversiteeya.services;


import tn.esprit.foyeruniversiteeya.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addUniversite(Universite universite);



    Universite getUniversite(long idUniversite);

    List<Universite> getAllUniversite();

    void deleteUniversite(long idUniversite);

    Universite updateUniversite(Universite universite);


}

package tn.esprit.foyeruniversiteeya.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.foyeruniversiteeya.entities.Universite;
import tn.esprit.foyeruniversiteeya.repositories.UniversiteRepository;


import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService{

    UniversiteRepository ur;


    @Override
    public Universite addUniversite(Universite universite) {
        return ur.save(universite);
    }

    @Override
    public Universite getUniversite(long idUniversite) {
        return ur.findById(idUniversite).orElse(null);
    }

    @Override
    public List<Universite> getAllUniversite() {
        return ur.findAll();
    }

    @Override
    public void deleteUniversite(long idUniversite) {
         ur.deleteById(idUniversite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return ur.save(universite);
    }

}

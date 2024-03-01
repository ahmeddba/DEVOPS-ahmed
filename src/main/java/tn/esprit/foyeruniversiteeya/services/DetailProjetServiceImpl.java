package tn.esprit.foyeruniversiteeya.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.foyeruniversiteeya.entities.DetailProjet;
import tn.esprit.foyeruniversiteeya.entities.Projet;
import tn.esprit.foyeruniversiteeya.repositories.DetailProjetRepository;
import tn.esprit.foyeruniversiteeya.repositories.ProjetRepository;

import java.util.List;

@Service
public class DetailProjetServiceImpl implements IDetailProjetService  {

    DetailProjetRepository detailprojetRepository;

    @Autowired
    public DetailProjetServiceImpl(DetailProjetRepository detailprojetRepository) {
        this.detailprojetRepository = detailprojetRepository;
    }




    @Override
    public  DetailProjet addDetailProjet( DetailProjet  detailprojet) {
        return  detailprojetRepository.save( detailprojet);
    }

    @Override
    public List< DetailProjet> getAllDetailProjet() {
        return (List< DetailProjet>)  detailprojetRepository.findAll();
    }

    @Override
    public  DetailProjet getDetailProjet(Long idDetail) {
        return  detailprojetRepository.findById(idDetail).orElse(null);
    }

    @Override
    public void deleteDetailProjet(Long idDetail) {
        detailprojetRepository.deleteById(idDetail);
    }

    @Override
    public DetailProjet updateDetailProjet(DetailProjet detailprojet) {

        return detailprojetRepository.save(detailprojet);
    }
}

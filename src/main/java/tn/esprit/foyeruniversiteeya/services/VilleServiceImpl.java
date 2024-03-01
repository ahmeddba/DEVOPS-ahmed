package tn.esprit.foyeruniversiteeya.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyeruniversiteeya.entities.Universite;
import tn.esprit.foyeruniversiteeya.entities.Ville;
import tn.esprit.foyeruniversiteeya.repositories.VilleRepository;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VilleServiceImpl implements IVilleService{
    VilleRepository villeRepository;
    @Override
    public Ville addVille(Ville ville) {
        return villeRepository.save(ville);
        //

    }

    @Override
    public List<Ville> getAllVilless() {
        List<Ville> ff = villeRepository.findAll();
        return   villeRepository.findAll();
    }

    @Override
    public Ville getVile(Long idVille) {
        return villeRepository.findById(idVille).orElse(null);
    }

    @Override
    public void deleteVille(Long idVille) {
villeRepository.deleteById(idVille);
    }

    @Override
    public Ville updateVille(Ville ville) throws Exception {

        Ville currentVille = villeRepository.findById(ville.getIdVille()).orElse(null);

       if(currentVille == null){
           throw  new Exception("ville ne existe pas ");
       }
       currentVille .setAddresse(ville.getAddresse());
       currentVille.setNom(ville.getNom());
        return villeRepository.save(currentVille);
    }


}

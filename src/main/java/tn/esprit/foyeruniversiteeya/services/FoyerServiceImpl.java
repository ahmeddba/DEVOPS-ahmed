package tn.esprit.foyeruniversiteeya.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.foyeruniversiteeya.entities.Foyer;
import tn.esprit.foyeruniversiteeya.repositories.FoyerRepository;

import java.util.List;

@Service
public class FoyerServiceImpl implements IFoyerService{
    FoyerRepository foyerRepository;

    @Autowired
    public FoyerServiceImpl(FoyerRepository foyerRepository){
        this.foyerRepository=foyerRepository;
    }

    @Override
    public Foyer addFoyer(Foyer foyer) {

        return foyerRepository.save(foyer);

    }

    @Override
    public List<Foyer> getAllFoyers() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    public Foyer getFoyer(Long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void deleteFoyer(Long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

   /* @Override
    public Foyer updateFoyer(Long id, Foyer foyer) {

        Foyer foyer1 = new Foyer();
        foyer1=foyerRepository.findById(id).get();
        if(foyer1!=null){
            foyer1.setNomFoyer(foyer.getNomFoyer());
            foyer1.setCapaciteFoyer(foyer.getCapaciteFoyer());
            foyer1.setImage(foyer.getImage());
            foyerRepository.save(foyer1);
            return  foyer1;
        }

        return null;
    }*/
   @Override
   public Foyer updateFoyer(Foyer foyer) {

       return foyerRepository.save(foyer);}
}

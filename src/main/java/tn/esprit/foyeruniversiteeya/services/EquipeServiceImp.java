package tn.esprit.foyeruniversiteeya.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.foyeruniversiteeya.entities.*;
import tn.esprit.foyeruniversiteeya.entities.Equipe;
import tn.esprit.foyeruniversiteeya.repositories.DetailEquipeRepository;
import tn.esprit.foyeruniversiteeya.repositories.EquipeRepository;
import tn.esprit.foyeruniversiteeya.repositories.ProjetRepository;

import java.util.List;
import java.util.Set;

@Service
public class EquipeServiceImp  implements IEquipeService{
    EquipeRepository equipeRepository;
    DetailEquipeRepository detailEquipeRepository;
    ProjetRepository projetRepository;

    @Autowired
    public EquipeServiceImp(EquipeRepository equipeRepository , DetailEquipeRepository detailEquipeRepository, ProjetRepository projetRepository){
        this.detailEquipeRepository = detailEquipeRepository;
        this.projetRepository=projetRepository;
        this.equipeRepository=equipeRepository;
    }

    @Override
    public Equipe addEquipe(Equipe equipe) {
        equipe.setNbrProjets(0);
        equipe.setNiveau(Niveau.JENIOR);
        return equipeRepository.save(equipe);
    }

    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe getEquipe(int idEquipe) {
        return equipeRepository.findById(idEquipe).orElse(null);
    }

    @Override
    public void deleteEquipe(int idEquipe) {
        equipeRepository.deleteById(idEquipe);

    }

    @Override
    public Equipe updateEquipe(Equipe equipe) {
        Equipe eq = equipeRepository.findById(equipe.getIdEquipe()).orElse(null);
        if (eq != null){
            return equipeRepository.save(equipe);
        }else {
            return equipe;
        }    }

    @Override
    public Equipe affecterClasseADepartment(int idEquipe, int idDetailEquipe) {
        Equipe equipeFound = equipeRepository.findById(idEquipe).orElse(null);
        DetailEquipe detailFound = detailEquipeRepository.findById(idDetailEquipe).orElse(null);
        if(detailFound != null && equipeFound != null) {
           // equipeFound.getDetailEquipes().add(detailFound);
            detailFound.setEquipe(equipeFound);
            detailEquipeRepository.save(detailFound);
            Equipe newequipeFound = equipeRepository.findById(idEquipe).orElse(null);
           return newequipeFound;
        }else {
            return null;
        }
    }



    @Override
    public Equipe affecterProjetAEquipe(int idEquipe, long idProjet) {
        Equipe equipeFound = equipeRepository.findById(idEquipe).orElse(null);
        Projet projetFound = projetRepository.findById(idProjet).orElse(null);
        if(projetFound != null && equipeFound != null) {

            projetFound.setEquipe(equipeFound);
            equipeFound.setScore(equipeFound.getScore()+20);
            equipeFound.setNiveau(determineNiveau(equipeFound.getScore()));
            equipeFound.setNbrProjets(equipeFound.getNbrProjets()+1);

            equipeRepository.save(equipeFound);
            projetRepository.save(projetFound);
            Equipe newequipeFound = equipeRepository.findById(idEquipe).orElse(null);

            return newequipeFound;
        }else {
            return null;
        }
    }

    private Niveau determineNiveau(int score) {
        // Logique pour déterminer le niveau en fonction du score
        // Par exemple, vous pouvez définir des seuils pour chaque niveau
        if (score >= 80) {
            return Niveau.EXPERT;
        } else if (score >= 60) {
            return Niveau.SENIOR;
        } else {
            return Niveau.JENIOR;
        }
    }

}

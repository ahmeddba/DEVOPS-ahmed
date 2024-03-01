package tn.esprit.foyeruniversiteeya.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEquipe")
    int idEquipe;
    String nomEquipe;
    String numLeader;
    int score;
    int nbrProjets;

    @Enumerated(EnumType.STRING)
    Niveau niveau;
    @OneToMany( mappedBy="equipe",cascade = CascadeType.ALL)
    private Set<DetailEquipe> detailEquipes;
    @OneToMany( mappedBy="equipe" , cascade = CascadeType.ALL)
    private Set<Projet> projets;

  /*  public Set<DetailEquipe> getDetailEquipes() {
        return DetailEquipes;
    }*/


}

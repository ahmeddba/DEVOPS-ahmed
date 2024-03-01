package tn.esprit.foyeruniversiteeya.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Projet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idProjet;
    String nomProjet;
    String dureProjet;
    @Enumerated(EnumType.STRING)
    Type typeProjet;
    Date dateDebutP;
    Date dateFinP;
    @OneToMany( mappedBy="projet" )
    private Set<DetailProjet> detailProjets;

    @ManyToOne
    @JsonIgnore
    Equipe equipe;
}

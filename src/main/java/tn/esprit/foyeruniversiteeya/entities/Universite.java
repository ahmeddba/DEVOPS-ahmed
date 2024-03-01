package tn.esprit.foyeruniversiteeya.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idUniversite;
    String nomUniversite;
    String adresse;
    String mail;
    String numero;
    @OneToOne
    private Foyer foyer;
    @ManyToOne
    Ville ville;

    @OneToMany(mappedBy="universite")
    @JsonIgnore
    private Set<Department> departements;

   /* @OneToMany( fetch = FetchType.EAGER)
    private List<Images> images;*/
}

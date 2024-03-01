package tn.esprit.foyeruniversiteeya.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.foyeruniversiteeya.entities.Universite;


@Repository
public interface UniversiteRepository extends JpaRepository<Universite,Long> {

    @Query("select u from Universite u where u.nomUniversite=:nomU") //JPQL  JPQL  JPQL  JPQL  JPQL JPQL  !+ PAS SQL
    Universite retrivebyNom(@Param("nomU") String nomUniversity);

    @Query(value ="select * from Universite u where u.nomUniversite=:nomU", nativeQuery = true) //JPQL  JPQL  JPQL  JPQL  JPQL JPQL  !+ PAS SQL
    Universite retrivebyNomSQL(@Param("nomU") String nomUniversity);

     Universite findByNomUniversite(String nom);

     Universite findByAdresse(String adresse);
}

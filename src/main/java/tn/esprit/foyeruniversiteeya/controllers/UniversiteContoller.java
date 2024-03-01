package tn.esprit.foyeruniversiteeya.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tn.esprit.foyeruniversiteeya.entities.Universite;
import tn.esprit.foyeruniversiteeya.services.IUniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Universite")
public class UniversiteContoller {

    IUniversiteService universiteService;


    @PostMapping("/addUniversity")
    Universite addUniversity(@RequestBody Universite universite){
        return universiteService.addUniversite(universite);
    }

    @GetMapping("/university/{id}")
    Universite retriveUniversite(@PathVariable long id){
        return universiteService.getUniversite(id);
    }

    @GetMapping("/university")
    List<Universite> retriveUniversites(){
        return universiteService.getAllUniversite();
    }

    @DeleteMapping("/deleteuniversity/{id}")
    void deleteUniversity(@PathVariable long id){
        universiteService.deleteUniversite(id);
    }

    @PutMapping("/updateuniversity")
    Universite updateUniversity(@RequestBody Universite universite){
        return universiteService.updateUniversite(universite);
    }


}

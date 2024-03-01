package tn.esprit.foyeruniversiteeya.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyeruniversiteeya.entities.Bloc;
import tn.esprit.foyeruniversiteeya.services.BlocServiceImpl;
import tn.esprit.foyeruniversiteeya.services.IBlocService;

import java.util.List;
@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocController {
    IBlocService blocService;
    @PostMapping("/addbloc")
    Bloc addBloc(@RequestBody Bloc bloc){
        return blocService.addBloc(bloc);
    }
    @GetMapping("/{id}")
    Bloc retrieveBloc(@PathVariable Long id){
        return blocService.getBloc(id);
    }
    @GetMapping("/bloc")
    List<Bloc> retrieveBlocs(){
        return blocService.getAllBlocs();
    }
    @DeleteMapping("/deletebloc/{id}")
    void deleteBloc(@PathVariable Long id){
        blocService.deleteBloc(id);
    }
    @PutMapping("/updatebloc")
    Bloc updateBloc(@RequestBody Bloc bloc){
        return blocService.updateBloc(bloc);
    }
}

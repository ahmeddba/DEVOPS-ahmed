package tn.esprit.foyeruniversiteeya.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyeruniversiteeya.entities.DetailEquipe;
import tn.esprit.foyeruniversiteeya.entities.Equipe;
import tn.esprit.foyeruniversiteeya.services.EquipeServiceImp;
import tn.esprit.foyeruniversiteeya.services.QrCodeGeneratorService;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Equipe")
public class EquipeController {
    EquipeServiceImp equipeServiceImp;

    private QrCodeGeneratorService qrCodeGeneratorService;

    @PostMapping("/addEquipe")
    Equipe addEquipe(@RequestBody Equipe equipe){
        return equipeServiceImp.addEquipe(equipe);
    }
    @GetMapping("/equipe/{id}")
    Equipe retrieveEquipe(@PathVariable int id){
        return equipeServiceImp.getEquipe(id);
    }
    @GetMapping("/equipe")
    List<Equipe> retrieveEquipes(){
        return equipeServiceImp.getAllEquipes();
    }
    @DeleteMapping("/equipe/{id}")
    void deleteEquipe(@PathVariable int id){
        equipeServiceImp.deleteEquipe(id);
    }
    @PutMapping("/updateEquipe")
    Equipe updateEquipe(@RequestBody Equipe equipe){
        return equipeServiceImp.updateEquipe(equipe);
    }
    @PostMapping("/affDetailEquipe/{idEquipe}/{idDetailEquipe}")
    Equipe affecteDetailEquipe(@PathVariable int idEquipe , @PathVariable int idDetailEquipe){
        return equipeServiceImp.affecterClasseADepartment(idEquipe , idDetailEquipe);
    }
    @GetMapping(value = "/qrcode/{idEquipe}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] generateQrCode(@PathVariable int idEquipe) throws IOException {
        int width = 200; //Adjust the desired width of the QR code
        int height = 200; //Adjust the desired height of the QR code
        Equipe equipeFound = equipeServiceImp.getEquipe(idEquipe);
        //String url = "http://127.0.0.1:8082/Equipe/equipe/"+idEquipe;
        String url = equipeFound.toString();
        return qrCodeGeneratorService.generateQrCodeImage(url, width, height);
    }
    @PostMapping("/{equipeId}/affecterProjet/{projetId}")
    public Equipe affecterProjetAEquipe(@PathVariable int equipeId, @PathVariable int projetId) {
      return  equipeServiceImp.affecterProjetAEquipe(equipeId, projetId);
    }
}

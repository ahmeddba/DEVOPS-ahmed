package tn.esprit.foyeruniversiteeya.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyeruniversiteeya.entities.SmsRequest;
import tn.esprit.foyeruniversiteeya.services.ServiceSMS;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Equipe")
public class Controller {

        private final ServiceSMS service;

    @Autowired
    public Controller(ServiceSMS service) {
        this.service = service;
    }

    @PostMapping("/sendsms")
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        service.sendSms(smsRequest);
    }
}
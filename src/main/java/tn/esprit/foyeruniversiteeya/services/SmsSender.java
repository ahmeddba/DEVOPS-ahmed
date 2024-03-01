package tn.esprit.foyeruniversiteeya.services;

import tn.esprit.foyeruniversiteeya.entities.SmsRequest;

public interface SmsSender {
    void sendSms(SmsRequest smsRequest);

    // or maybe void sendSms(String phoneNumber, String message);
}

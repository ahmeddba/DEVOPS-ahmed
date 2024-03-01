package tn.esprit.foyeruniversiteeya.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import tn.esprit.foyeruniversiteeya.entities.SmsRequest;

@org.springframework.stereotype.Service
public class ServiceSMS {

    private final SmsSender smsSender;

    @Autowired
    public ServiceSMS(@Qualifier("twilio") TwilioSmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void sendSms(SmsRequest smsRequest) {
        smsSender.sendSms(smsRequest);
    }
}
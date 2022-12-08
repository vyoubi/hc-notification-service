package de.haegerconsulting.internShop.hcnotificationservice.twilio;

import de.haegerconsulting.internShop.hcnotificationservice.emails.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TwilioService {

    @Autowired
    EmailSender emailSender;

    @Autowired
    private TwilioRepository twilioRepository;

    private final SmsSender sendSms;

    @Autowired
    public TwilioService(@Qualifier("twilio") TwilioSmsSender twilioSmsSender) {
        this.sendSms = twilioSmsSender;
    }

    public void sendSms(SmsRequest smsRequest) {
        this.twilioRepository.save(smsRequest);
        sendSms.sendSms(smsRequest);
    }

    public List<SmsRequest> findAllSms() {
        return twilioRepository.findAll();
    }
}

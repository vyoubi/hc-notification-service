package de.haegerconsulting.internShop.hcnotificationservice.twilio;

public interface SmsSender {

    void sendSms(SmsRequest smsRequest);
}

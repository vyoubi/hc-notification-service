package de.haegerconsulting.internShop.hcnotificationservice.twilio;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/notifications/sms")
@RequiredArgsConstructor
public class TwilioController {

    private final TwilioService serviceTwilio;

    @PostMapping("/order")
    public void OrdersendSms(@Valid @RequestBody SmsRequest smsRequest) {
        serviceTwilio.sendSms(smsRequest);
    }

    @PostMapping("/payment")
    public void PaymentsendSms(@Valid @RequestBody SmsRequest smsRequest) {
        serviceTwilio.sendSms(smsRequest);
    }

    @GetMapping()
    public List<SmsRequest> getAllSms() {
        return serviceTwilio.findAllSms();
    }

}

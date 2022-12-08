package de.haegerconsulting.internShop.hcnotificationservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TwilioConfiguration {

    private String accountSid;
    private String authToken;
    private String trialNumber;

}


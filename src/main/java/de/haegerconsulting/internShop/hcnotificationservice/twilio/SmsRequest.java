package de.haegerconsulting.internShop.hcnotificationservice.twilio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class SmsRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long smsId;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String message;

}

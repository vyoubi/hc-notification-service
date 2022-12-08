package de.haegerconsulting.internShop.hcnotificationservice.twilio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TwilioRepository extends JpaRepository<SmsRequest, Long> {

}

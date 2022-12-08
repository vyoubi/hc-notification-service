package de.haegerconsulting.internShop.hcnotificationservice;

import de.haegerconsulting.internShop.hcnotificationservice.emails.EmailSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
@EnableEurekaClient
public class HcNotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcNotificationServiceApplication.class, args);
	}

	@Bean
	public Consumer<String> notificationEventSupplier() {
		return message -> {
			new EmailSender().sendOrderEmail(message);
			new EmailSender().sendPaymentEmail(message);
		};
	}

}

package de.haegerconsulting.internShop.hcnotificationservice.emails;

import org.springframework.stereotype.Service;

@Service
public class EmailSender {

    public void sendOrderEmail(String orderNumber) {
        System.out.println("Order placed successfully - Order Number is " + orderNumber);

        System.out.println("Email sent");

    }

    public void sendPaymentEmail(String paymentStatus) {
        System.out.println("Payment Status: " + paymentStatus);

        System.out.println("Email sent");

    }

}

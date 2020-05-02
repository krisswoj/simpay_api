package pl.simpay.api.type.db.controller;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.simpay.api.type.db.domain.PaymentResponse;
import pl.simpay.api.type.db.service.PaymentResponseBuilder;
import pl.simpay.api.type.db.type.PaymentResponseStatus;

@RestController
public class DbResponseController {

    private static final String CONFIRMATION_RESPONSE = "OK";

    @PostMapping(value = "/simpay_api")
    public String getBook(@RequestParam MultiValueMap<String, String> responseData) {

        PaymentResponse paymentResponse = PaymentResponseBuilder.buildPaymentResponse(responseData);

        if (PaymentResponseStatus.ORDER_PAYED.equals(paymentResponse.getStatus())) {
            System.out.println("Payment has been successfully completed");
        }

        if (PaymentResponseStatus.ORDER_ACCEPTED.equals(paymentResponse.getStatus())) {
            System.out.println("Order has been accepted - but not paid yet");
        }

        if (PaymentResponseStatus.ORDER_REJECTED.equals(paymentResponse.getStatus())) {
            System.out.println("Payment has been rejected");
        }

        return CONFIRMATION_RESPONSE;
    }
}

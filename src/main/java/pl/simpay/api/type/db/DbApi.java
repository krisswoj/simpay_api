package pl.simpay.api.type.db;

import pl.simpay.api.type.db.domain.PaymentRequest;
import pl.simpay.api.type.db.service.PaymentRequestService;
import pl.simpay.api.type.db.type.AmountType;
import pl.simpay.api.type.db.type.PaymentRequestStatus;

import java.io.IOException;

public class DbApi {

    public void getPaymentLink() throws IOException {
        PaymentRequestService paymentRequestService = new PaymentRequestService();
        PaymentRequest paymentRequest = paymentRequestService.createPaymentRequest("128", "123", AmountType.AMOUNT, "1.00");

        if (PaymentRequestStatus.SUCCESS.getStatus().equals(paymentRequest.getStatus())) {
            System.out.println("Payment link: " + paymentRequest.getLink());
        }

        if (PaymentRequestStatus.FAILURE.getStatus().equals(paymentRequest.getStatus())) {
            System.out.println("Error message: " + paymentRequest.getMessage());
        }
    }
}

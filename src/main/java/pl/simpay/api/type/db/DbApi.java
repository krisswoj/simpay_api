package pl.simpay.api.type.db;

import pl.simpay.api.type.db.domain.DbUrlRequest;
import pl.simpay.api.type.db.service.DbUrlRequestService;
import pl.simpay.api.type.db.type.AmountType;
import pl.simpay.api.type.db.type.PaymentRequestStatus;

import java.io.IOException;

public class DbApi {

    public void getPaymentLink() throws IOException {
        DbUrlRequestService dbUrlRequestService = new DbUrlRequestService();
        DbUrlRequest dbUrlRequest = dbUrlRequestService.createPaymentRequest("128", "123", AmountType.AMOUNT, "1.00");

        if (PaymentRequestStatus.SUCCESS.getStatus().equals(dbUrlRequest.getStatus())) {
            System.out.println("Payment link: " + dbUrlRequest.getLink());
        }

        if (PaymentRequestStatus.FAILURE.getStatus().equals(dbUrlRequest.getStatus())) {
            System.out.println("Error message: " + dbUrlRequest.getMessage());
        }
    }
}

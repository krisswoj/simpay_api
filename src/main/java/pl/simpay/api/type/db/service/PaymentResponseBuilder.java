package pl.simpay.api.type.db.service;

import org.springframework.util.MultiValueMap;
import pl.simpay.api.type.db.domain.PaymentResponse;
import pl.simpay.api.type.db.type.PaymentResponseStatus;

public class PaymentResponseBuilder {

    private PaymentResponseBuilder() {
        //empty
    }

    public static PaymentResponse buildPaymentResponse(MultiValueMap<String, String> responseData) {
        return new PaymentResponse(
                responseData.getFirst("id"),
                PaymentResponseStatus.valueOf(responseData.getFirst("status")),
                responseData.getFirst("valuenet"),
                responseData.getFirst("valuenet_gross"),
                responseData.getFirst("valuepartner"),
                responseData.getFirst("control"),
                responseData.getFirst("number_from"),
                responseData.getFirst("sign")
        );
    }
}

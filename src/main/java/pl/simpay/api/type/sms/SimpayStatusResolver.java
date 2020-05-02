package pl.simpay.api.type.sms;

import pl.simpay.api.type.sms.response.SimpayStatusType;
import pl.simpay.api.type.sms.response.domain.SmsStatusResponse;

import static java.util.Objects.nonNull;

public class SimpayStatusResolver {

    private SimpayStatusResolver() {
        // empty
    }

    public static boolean isSuccess(SmsStatusResponse response) {
        return nonNull(response)
                && nonNull(response.getRespond())
                && nonNull(response.getRespond().getStatus())
                && SimpayStatusType.OK.name().equals(response.getRespond().getStatus());
    }

    public static boolean isUsed(SmsStatusResponse response) {
        return nonNull(response)
                && nonNull(response.getRespond())
                && nonNull(response.getRespond().getStatus())
                && SimpayStatusType.USED.name().equals(response.getRespond().getStatus());
    }
}

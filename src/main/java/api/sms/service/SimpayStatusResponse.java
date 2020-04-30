package api.sms.service;

import api.sms.service.model.SimpayStatusType;
import api.sms.service.response.SimpayResponse;

import static java.util.Objects.nonNull;

public class SimpayStatusResponse {
    private SimpayResponse response;

    public SimpayStatusResponse(SimpayResponse response) {
        this.response = response;
    }

    public boolean isSuccess() {
        return nonNull(response)
                && nonNull(response.getRespond())
                && nonNull(response.getRespond().getStatus())
                && SimpayStatusType.OK.name().equals(response.getRespond().getStatus());
    }

    public boolean isUsed() {
        return nonNull(response)
                && nonNull(response.getRespond())
                && nonNull(response.getRespond().getStatus())
                && SimpayStatusType.USED.name().equals(response.getRespond().getStatus());
    }
}

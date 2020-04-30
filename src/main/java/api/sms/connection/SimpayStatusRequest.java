package api.sms.connection;

import api.sms.models.SimpayStatusParameters;

public class SimpayStatusRequest extends SimpayRequest<SimpayStatusParameters> {
    public SimpayStatusRequest(SimpayStatusParameters parameters) {
        super(parameters);
    }
}

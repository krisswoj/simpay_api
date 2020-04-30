package api.sms.connection;

import api.sms.models.SimpayStatusParameters;
import api.sms.models.SimpayStatusRespond;
import api.sms.models.SimpayStatusType;

public class SimpayStatusResponse extends SimpayResponse<SimpayStatusRespond, SimpayStatusParameters> {
    public SimpayStatusResponse(SimpayStatusRespond respond, SimpayStatusParameters parameters) {
        super(respond, parameters);
    }

    public boolean isSuccess() {
        return this.getRespond() != null
                && this.getRespond().getStatus() == SimpayStatusType.OK;
    }

    public boolean isUsed() {
        return this.isError()
                && this.getRespond() != null
                && this.getRespond().getStatus() == SimpayStatusType.USED;
    }

    public boolean isNotFound() {
        return this.isError()
                && this.getError().getCode() == 404;
    }

    public boolean isError() {
        return !this.isSuccess()
                && this.getError() != null;
    }
}

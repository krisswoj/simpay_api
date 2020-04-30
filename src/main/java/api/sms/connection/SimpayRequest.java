package api.sms.connection;

import api.sms.models.SimpayError;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SimpayRequest<P> {

    @SerializedName("error")
    private final List<SimpayError> errors = new ArrayList<>();

    @SerializedName("params")
    private P parameters;

    public SimpayRequest(P parameters) {
        this.parameters = parameters;
    }

    public P getParameters() {
        return parameters;
    }

    public void setParameters(P parameters) {
        this.parameters = parameters;
    }

    public SimpayError getError() {
        return this.errors.size() < 1
                ? null
                : this.errors.get(0);
    }
}

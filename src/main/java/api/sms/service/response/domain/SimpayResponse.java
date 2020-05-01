package api.sms.service.response.domain;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SimpayResponse {

    @SerializedName("error")
    @Expose
    private List<Error> error = null;

    @SerializedName("params")
    @Expose
    private Params params;

    @SerializedName("respond")
    @Expose
    private Respond respond;

    public List<Error> getError() {
        return error;
    }

    public void setError(List<Error> error) {
        this.error = error;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public Respond getRespond() {
        return respond;
    }

    public void setRespond(Respond respond) {
        this.respond = respond;
    }
}

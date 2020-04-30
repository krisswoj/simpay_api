package api.sms.service.request;

import com.google.gson.annotations.SerializedName;

public class StatusRequest {

    @SerializedName("params")
    private StatusParameters statusParameters;

    public StatusRequest(String serviceId, String number, String code) {
        this.statusParameters = new StatusParameters(serviceId, number, code);
    }
}

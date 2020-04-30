package api.sms.models;

import com.google.gson.annotations.SerializedName;

import static config.ApiParameters.PARTNER_KEY;
import static config.ApiParameters.PARTNER_SECRET;

public class SimpayStatusParameters {

    @SerializedName("service_id")
    private String serviceId;
    private String number;
    private String code;
    private SimpayAuth auth;

    public SimpayStatusParameters(String serviceId, String number, String code) {
        this.auth = new SimpayAuth(PARTNER_KEY, PARTNER_SECRET);
        this.serviceId = serviceId;
        this.number = number;
        this.code = code;
    }
}

package pl.simpay.api.sms.request;

import com.google.gson.annotations.SerializedName;

import static pl.simpay.api.config.ApiParameters.PARTNER_KEY;
import static pl.simpay.api.config.ApiParameters.PARTNER_SECRET;

public class StatusParameters {

    @SerializedName("service_id")
    private String serviceId;
    private String number;
    private String code;
    private String key;
    private String secret;

    public StatusParameters(String serviceId, String number, String code) {
        this.serviceId = serviceId;
        this.number = number;
        this.code = code;
        this.key = PARTNER_KEY;
        this.secret = PARTNER_SECRET;
    }
}

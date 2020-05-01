package pl.simpay.api.sms;

import pl.simpay.api.sms.request.StatusRequest;
import pl.simpay.api.sms.response.domain.SimpayResponse;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static pl.simpay.api.config.ApiParameters.API_URL;
import static pl.simpay.api.sms.util.GsonUtil.convertSimpayResponse;
import static pl.simpay.api.sms.util.GsonUtil.serializeToJson;

public class SmsApi {

    public SimpayResponse getStatus(String serviceId, String number, String code) throws IOException {
        StatusRequest statusRequest = new StatusRequest(serviceId, number, code);
        InputStream inputStream = receiveInputStream(statusRequest);

        return convertSimpayResponse(inputStream);
    }

    private InputStream receiveInputStream(StatusRequest statusRequest) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(API_URL).openConnection();
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.getOutputStream().write(serializeToJson(statusRequest));

        return connection.getInputStream();
    }
}

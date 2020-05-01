package api.sms;

import api.sms.service.request.StatusRequest;
import api.sms.service.response.domain.SimpayResponse;
import api.sms.service.util.GsonUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static api.sms.service.util.GsonUtil.serializeToJson;
import static config.ApiParameters.API_URL;

public class SmsApi {

    public SimpayResponse getStatus(String serviceId, String number, String code) throws IOException {
        StatusRequest statusRequest = new StatusRequest(serviceId, number, code);
        InputStream inputStream = receiveInputStream(statusRequest);

        return GsonUtil.convertSimpayResponse(inputStream);
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

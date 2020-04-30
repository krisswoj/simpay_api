package api.sms;

import api.sms.connection.SimpayStatusRequest;
import api.sms.connection.SimpayStatusResponse;
import api.sms.models.SimpayStatusParameters;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static api.sms.util.GsonUtil.GSON;
import static config.ApiParameters.API_URL;

public class SimpayApi {

    public SimpayStatusResponse getStatus(String serviceId, String number, String code) throws IOException {
        SimpayStatusParameters parameters = new SimpayStatusParameters(serviceId, number, code);
        SimpayStatusRequest statusRequest = new SimpayStatusRequest(parameters);

        HttpURLConnection connection = (HttpURLConnection) new URL(API_URL).openConnection();
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.getOutputStream().write(GSON.toJson(statusRequest).getBytes(StandardCharsets.UTF_8));

        return GSON.fromJson(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8), SimpayStatusResponse.class);
    }
}

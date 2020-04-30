package api.sms;

import api.sms.service.request.StatusRequest;
import api.sms.service.response.SimpayResponse;
import api.sms.service.util.GsonUtil;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static api.sms.service.util.GsonUtil.GSON;
import static config.ApiParameters.API_URL;

public class SmsApi {

    public SimpayResponse getStatus(String serviceId, String number, String code) throws IOException {
        StatusRequest statusRequest = new StatusRequest(serviceId, number, code);
        HttpURLConnection httpUrlConnection = createHttpUrlConnection(statusRequest);

        return getSimpayResponse(httpUrlConnection);
    }

    private SimpayResponse getSimpayResponse(HttpURLConnection httpURLConnection) throws IOException {

        return GsonUtil.convertSimpayResponse(httpURLConnection);
    }

    private HttpURLConnection createHttpUrlConnection(StatusRequest statusRequest) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(API_URL).openConnection();
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.getOutputStream().write(GSON.toJson(statusRequest).getBytes(StandardCharsets.UTF_8));

        return connection;
    }
}

package pl.simpay.api.type.sms.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import pl.simpay.api.type.sms.request.StatusRequest;
import pl.simpay.api.type.sms.response.domain.SmsStatusResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static pl.simpay.config.ApiParameters.SMS_API_URL;

public class SmsRequestService {

    private static final Gson GSON = new GsonBuilder().create();

    public SmsStatusResponse getResponse(String serviceId, String number, String code) throws IOException {
        StatusRequest statusRequest = new StatusRequest(serviceId, number, code);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SMS_API_URL);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setEntity(new StringEntity(toJson(statusRequest)));
        HttpResponse response = client.execute(httpPost);

        return convertToSmsStatusResponse(response.getEntity().getContent());
    }

    private SmsStatusResponse convertToSmsStatusResponse(InputStream inputStream) {
        return GSON.fromJson(new InputStreamReader(inputStream, StandardCharsets.UTF_8), SmsStatusResponse.class);
    }

    private String toJson(StatusRequest statusRequest) {
        return GSON.toJson(statusRequest);
    }
}

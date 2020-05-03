package pl.simpay.api.type.sms.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;
import pl.simpay.api.type.ParametersWrapper;
import pl.simpay.api.type.sms.request.StatusParameters;
import pl.simpay.api.type.sms.response.domain.SmsStatusResponse;
import pl.simpay.api.util.GsonUtil;

import java.io.IOException;

import static pl.simpay.config.ApiParameters.SMS_API_URL;

@Service
public class SmsRequestService {

    private static final Gson GSON = new GsonBuilder().create();

    public SmsStatusResponse getResponse(String serviceId, String number, String code) throws IOException {
        ParametersWrapper parameters = new ParametersWrapper(new StatusParameters(serviceId, number, code));

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SMS_API_URL);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setEntity(new StringEntity(GsonUtil.toJson(parameters)));
        HttpResponse response = client.execute(httpPost);

        return GsonUtil.convertToSmsStatusResponse(response.getEntity().getContent());
    }
}

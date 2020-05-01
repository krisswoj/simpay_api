package api.sms.service.util;

import api.sms.service.request.StatusRequest;
import api.sms.service.response.domain.SimpayResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class GsonUtil {

    private GsonUtil() {
        //empty
    }

    public static final Gson GSON = new GsonBuilder().create();

    public static SimpayResponse convertSimpayResponse(InputStream inputStream) {
        return GSON.fromJson(new InputStreamReader(inputStream, StandardCharsets.UTF_8), SimpayResponse.class);
    }

    public static byte[] serializeToJson(StatusRequest statusRequest) {
        return GSON.toJson(statusRequest).getBytes(StandardCharsets.UTF_8);
    }
}
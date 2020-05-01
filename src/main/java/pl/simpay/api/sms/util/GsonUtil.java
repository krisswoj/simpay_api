package pl.simpay.api.sms.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.simpay.api.sms.request.StatusRequest;
import pl.simpay.api.sms.response.domain.SimpayResponse;

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
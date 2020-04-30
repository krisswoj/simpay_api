package api.sms.service.util;

import api.sms.service.response.SimpayResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

public class GsonUtil {

    private GsonUtil() {
        //empty
    }

    public static final Gson GSON = new GsonBuilder().create();

    public static SimpayResponse convertSimpayResponse(HttpURLConnection httpURLConnection) throws IOException {
        return GSON.fromJson(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8), SimpayResponse.class);
    }
}
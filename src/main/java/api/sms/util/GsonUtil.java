package api.sms.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {

    private GsonUtil() {
        //empty
    }

    public static final Gson GSON = new GsonBuilder().registerTypeAdapterFactory(new SkipArrayAdapterFactory()).create();



}

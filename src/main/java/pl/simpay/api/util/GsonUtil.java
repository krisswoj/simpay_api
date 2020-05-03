package pl.simpay.api.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.simpay.api.type.ParametersWrapper;
import pl.simpay.api.type.db.domain.dbmaxtransactionvalue.DbMaxTransactionValueResponse;
import pl.simpay.api.type.db.domain.dbservicecommission.DbServiceCommissionResponse;
import pl.simpay.api.type.db.domain.dbservicelist.DbServiceListResponse;
import pl.simpay.api.type.db.domain.paymentinformation.PaymentStatusResponse;
import pl.simpay.api.type.sms.response.domain.SmsStatusResponse;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class GsonUtil {

    private static final Gson GSON = new GsonBuilder().create();

    private GsonUtil() {
        //empty
    }

    public static String toJson(ParametersWrapper parametersWrapper) {
        return GSON.toJson(parametersWrapper);
    }

    public static SmsStatusResponse convertToSmsStatusResponse(InputStream inputStream) {
        return convertToObject(inputStream, SmsStatusResponse.class);
    }

    public static PaymentStatusResponse convertToPaymentStatusResponse(InputStream inputStream) {
        return convertToObject(inputStream, PaymentStatusResponse.class);
    }

    public static DbServiceListResponse convertToDbServiceListResponse(InputStream inputStream) {
        return convertToObject(inputStream, DbServiceListResponse.class);
    }

    public static DbMaxTransactionValueResponse convertToDbMaxTransactionValueResponse(InputStream inputStream) {
        return convertToObject(inputStream, DbMaxTransactionValueResponse.class);
    }
    public static DbServiceCommissionResponse convertToDbServiceCommissionResponse(InputStream inputStream) {
        return convertToObject(inputStream, DbServiceCommissionResponse.class);
    }

    private static <T> T convertToObject(InputStream inputStream, Class<T> tClass) {
        return GSON.fromJson(new InputStreamReader(inputStream, StandardCharsets.UTF_8), tClass);
    }
}

package pl.simpay.api.util;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;

public class Sha256Util {

    private Sha256Util() {
        //empty
    }

    public static boolean isSignatureValid(String sign) {
        return true;
    }

    public static void createDbPaymentControlSign(List<NameValuePair> params, String serviceId, String amountValue, String control) {
        params.add(new BasicNameValuePair("sign", "xxx"));
    }

}

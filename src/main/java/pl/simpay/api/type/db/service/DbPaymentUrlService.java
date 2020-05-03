package pl.simpay.api.type.db.service;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;
import pl.simpay.api.type.db.domain.DbPaymentUrl;
import pl.simpay.api.type.db.type.AmountType;
import pl.simpay.api.util.Sha256Util;
import pl.simpay.api.util.GsonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pl.simpay.config.ApiParameters.DB_API_URL;

@Service
public class DbPaymentUrlService {

    public DbPaymentUrl createPaymentUrl(String serviceId, String control, AmountType amountType, String amountValue) throws IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(DB_API_URL);
        List<NameValuePair> params = createParams(serviceId, control, amountType, amountValue);
        httpPost.setEntity(new UrlEncodedFormEntity(params));
        HttpResponse response = client.execute(httpPost);

        return GsonUtil.convertToDbPaymentUrl(response.getEntity().getContent());
    }

    private List<NameValuePair> createParams(String serviceId, String control, AmountType amountType, String amountValue) {
        List<NameValuePair> params = new ArrayList<>();

        //Service ID from Simpay partner panel
        //Required: yes
        //Type: String
        params.add(new BasicNameValuePair("serviceId", serviceId));

        //Your own transaction ID
        //Required: yes
        //Type: String
        params.add(new BasicNameValuePair("control", control));

        //Type of amount which will be charged your customer
        //"amount" - net value of transaction (will be increased by 23% VAT)
        //"amount_gross" - gross value of transaction (with 23% VAT)
        //"amount_required" - real commission which you have to receive, independently of the mobile operator
        //amount value - "1.00" is 1,00 zł, 0.01 is 0,01 zł, 10.00 is 10,00 zł etc.
        //Required: yes, one of the above
        //Type: String
        params.add(new BasicNameValuePair(amountType.getType(), amountValue));

        //URL to redirect after success payment
        //Required: no
        //Type: String
        params.add(new BasicNameValuePair("complete", "https://your.domain.com/success"));

        //URL to redirect after unsuccessful payment
        //Required: no
        //Type: String
        params.add(new BasicNameValuePair("failure", "https://your.domain.com/failure"));

        //Set mobile operator
        //"1" – Orange,
        //"2" – Play,
        //"3" – T-Mobile,
        //"4" – Plus GSM
        //Required: no, by default Simpay will recognize the operator based on the mobile phone number
        //Type: String
        params.add(new BasicNameValuePair("provider", "1"));

        Sha256Util.createDbPaymentControlSign(params, serviceId, amountValue, control);

        return params;
    }

}
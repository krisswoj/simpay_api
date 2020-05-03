package pl.simpay.api.type.db.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import pl.simpay.api.type.ParametersWrapper;
import pl.simpay.api.type.db.domain.dbmaxtransactionvalue.DbMaxTransactionValueRequest;
import pl.simpay.api.type.db.domain.dbmaxtransactionvalue.DbMaxTransactionValueResponse;
import pl.simpay.api.type.db.domain.dbservicecommission.DbServiceCommissionRequest;
import pl.simpay.api.type.db.domain.dbservicecommission.DbServiceCommissionResponse;
import pl.simpay.api.type.db.domain.dbservicelist.DbServiceListRequest;
import pl.simpay.api.type.db.domain.dbservicelist.DbServiceListResponse;
import pl.simpay.api.type.db.domain.paymentinformation.PaymentStatusRequest;
import pl.simpay.api.type.db.domain.paymentinformation.PaymentStatusResponse;
import pl.simpay.api.util.GsonUtil;

import java.io.IOException;

import static pl.simpay.config.ApiParameters.*;

public class DbService {

    public PaymentStatusResponse getPaymentStatus(String transactionId) throws IOException {
        HttpResponse response = getResponse(new ParametersWrapper(new PaymentStatusRequest(transactionId)), DB_STATUS_API_URL);

        return GsonUtil.convertToPaymentStatusResponse(response.getEntity().getContent());
    }

    public DbServiceListResponse getDbServices() throws IOException {
        HttpResponse response = getResponse(new ParametersWrapper(new DbServiceListRequest()), DB_SERVICES_LIST_URL);

        return GsonUtil.convertToDbServiceListResponse(response.getEntity().getContent());
    }

    public DbMaxTransactionValueResponse getDbMaxTransactionValue(String serviceId) throws IOException {
        HttpResponse response = getResponse(new ParametersWrapper(new DbMaxTransactionValueRequest(serviceId)), DB_MAX_TRANSACTION_VALUE_URL);

        return GsonUtil.convertToDbMaxTransactionValueResponse(response.getEntity().getContent());
    }

    public DbServiceCommissionResponse getDbServiceCommission(String serviceId) throws IOException {
        HttpResponse response = getResponse(new ParametersWrapper(new DbServiceCommissionRequest(serviceId)), DB_SERVICE_COMMISSION_URL);

        return GsonUtil.convertToDbServiceCommissionResponse(response.getEntity().getContent());
    }

    private HttpResponse getResponse(ParametersWrapper parameters, String url) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setEntity(new StringEntity(GsonUtil.toJson(parameters)));

        return client.execute(httpPost);
    }
}

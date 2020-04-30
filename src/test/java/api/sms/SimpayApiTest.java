package api.sms;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SimpayApiTest {

    @Test
    public void sampleTest() throws IOException {
        SmsApi smsApi = new SmsApi();

        smsApi.getStatus("", "", "");

        assertEquals(smsApi, "");
    }
}
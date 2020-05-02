package pl.simpay.api.type.sms;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SmsApiTest {

    @Test
    void test() throws IOException {
        SmsApi smsApi = new SmsApi();

        smsApi.getResponse("xx", "xx", "xx");
    }

}
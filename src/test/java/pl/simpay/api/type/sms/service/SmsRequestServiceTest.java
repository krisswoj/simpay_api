package pl.simpay.api.type.sms.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SmsRequestServiceTest {


    @Test
    void test() throws IOException {
        SmsRequestService smsRequestService = new SmsRequestService();

        smsRequestService.getResponse("123", "7136", "2222");
    }

}
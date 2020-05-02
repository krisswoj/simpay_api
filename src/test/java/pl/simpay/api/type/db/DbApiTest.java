package pl.simpay.api.type.db;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DbApiTest {



    @Test
    void test() throws IOException {
        DbApi dbApi = new DbApi();

        dbApi.getPaymentLink();
    }


}
package api.sms;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SimpayApiTest {

    @Test
    public void sdsfg() throws IOException {
        SimpayApi simpayApi = new SimpayApi();


        simpayApi.getStatus("11", "11", "dd");



        assertEquals(simpayApi, "");

    }

}
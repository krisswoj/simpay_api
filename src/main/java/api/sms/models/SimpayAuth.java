package api.sms.models;

public class SimpayAuth {
    private String key;
    private String secret;

    public SimpayAuth(String key, String secret) {
        this.key = key;
        this.secret = secret;
    }
}

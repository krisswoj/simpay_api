package api.sms.connection;

public class SimpayResponse<R, P> extends SimpayRequest<P> {
    private R respond;

    public SimpayResponse(R respond, P parameters) {
        super(parameters);
        this.respond = respond;
    }

    public R getRespond() {
        return respond;
    }

    public void setRespond(R respond) {
        this.respond = respond;
    }
}

package pl.simpay.api.type.db.domain;

import pl.simpay.api.type.db.type.PaymentResponseStatus;

public class DbPaymentResponse {
    private String id;
    private PaymentResponseStatus status;
    private String valuenet;
    private String valuenetGross;
    private String valuePartner;
    private String control;
    private String numberFrom;
    private String sign;

    public DbPaymentResponse(String id, PaymentResponseStatus status, String valuenet, String valuenetGross, String valuePartner, String control, String numberFrom, String sign) {
        this.id = id;
        this.status = status;
        this.valuenet = valuenet;
        this.valuenetGross = valuenetGross;
        this.valuePartner = valuePartner;
        this.control = control;
        this.numberFrom = numberFrom;
        this.sign = sign;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PaymentResponseStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentResponseStatus status) {
        this.status = status;
    }

    public String getValuenet() {
        return valuenet;
    }

    public void setValuenet(String valuenet) {
        this.valuenet = valuenet;
    }

    public String getValuenetGross() {
        return valuenetGross;
    }

    public void setValuenetGross(String valuenetGross) {
        this.valuenetGross = valuenetGross;
    }

    public String getValuePartner() {
        return valuePartner;
    }

    public void setValuePartner(String valuePartner) {
        this.valuePartner = valuePartner;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getNumberFrom() {
        return numberFrom;
    }

    public void setNumberFrom(String numberFrom) {
        this.numberFrom = numberFrom;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}

package pl.simpay.api.type;

import com.google.gson.annotations.SerializedName;

public class ParamsWrapper<T> {

    @SerializedName("params")
    private T params;

    public ParamsWrapper(T params) {
        this.params = params;
    }
}

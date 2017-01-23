
package com.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RootModel {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("code")
    @Expose
    private Integer code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RootModel withMessage(String message) {
        this.message = message;
        return this;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public RootModel withData(Data data) {
        this.data = data;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public RootModel withCode(Integer code) {
        this.code = code;
        return this;
    }

}

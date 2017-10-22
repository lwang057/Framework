package com.lwang.framework.model.api;

import java.io.Serializable;

/**
 * ServerResponse.class
 *
 * @author lwang
 * @date 2017/10/22.
 */
@SuppressWarnings("unused")
public class ServerResponse<T> implements Serializable {

    private String resultcode;
    private String reason;
    private T result;
    private int error_code;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}

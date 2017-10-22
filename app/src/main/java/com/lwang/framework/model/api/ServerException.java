package com.lwang.framework.model.api;

/**
 * ServerException.class
 *
 * @author lwang
 * @date 2017/10/22.
 */

public class ServerException extends RuntimeException {

    private int returnCode;
    private String returnMsg;

    public ServerException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.returnCode = errorCode;
        this.returnMsg = errorMessage;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }
}

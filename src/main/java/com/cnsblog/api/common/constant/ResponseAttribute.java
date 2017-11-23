package com.cnsblog.api.common.constant;

public enum ResponseAttribute {

    SERVER_CODE("serverCode"),
    SERVER_MSG("serverMsg"),
    RESULTS("results"),
    ERROR_CODE("errorCode"),
    ERROR_CODE_MSG("errorCodeMsg");

    String code;
    ResponseAttribute(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

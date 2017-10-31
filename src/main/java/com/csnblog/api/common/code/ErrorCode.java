package com.csnblog.api.common.code;

public enum ErrorCode {


    ERR0001("ERR0001","개발자 정의 에러 코드1")
    , ERR0002("ERR0002","개발자 정의 에러 코드2")
    , ERR0003("ERR0003","개발자 정의 에러 코드3")
    , ERR0004("ERR0004","개발자 정의 에러 코드4");


    private String errMsg;
    private String errCode;

    private ErrorCode(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getCode() {
        return errCode;
    }

    public String getMsg() {
        return errMsg;
    }

}

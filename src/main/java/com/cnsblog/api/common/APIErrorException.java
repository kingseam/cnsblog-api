package com.cnsblog.api.common;

import com.cnsblog.api.common.code.ErrorCode;

public class APIErrorException extends RuntimeException{

    private ErrorCode errorCode;
    public APIErrorException (ErrorCode errorMSG){
        this.errorCode = errorMSG;
    }

    public APIErrorException (ErrorCode errorMSG, Exception e){
        this.errorCode = errorMSG;
        super.initCause(e);
    }

    public String getErrorCode(){
        return this.errorCode.getCode();
    }

    public String getErrorMsg(){
        return this.errorCode.getMsg();
    }

    public ErrorCode getError(){ return this.errorCode; }

}

package com.cnsblog.api.common.exception;

public class JsonException extends RuntimeException {
    public JsonException(String message){
        super(message);
    }

    public JsonException(String message, Exception exception){
        super(message, exception);
    }

    public static JsonException serialize(Object target, Exception exception){
        return new JsonException("json serialize exception target :: " + target, exception);
    }

    public static JsonException deserialize(String target, Exception exception){
        return new JsonException("json deserialize exception target :: " + target, exception);
    }
}

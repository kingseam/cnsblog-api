package com.cnsblog.api.common.utils;

import com.cnsblog.api.common.exception.JsonException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtils {
    // ObjectMapper는 멀티스레드에 안전
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String toJson(Object target){
        try {
            return OBJECT_MAPPER.writeValueAsString(target);
        } catch (IOException e) {
            throw JsonException.serialize(target, e);
        }
    }

    public static <T> T fromJson(String target, Class<T> tClass){
        try {
            return OBJECT_MAPPER.readValue(target, tClass);
        } catch (IOException e) {
            throw JsonException.deserialize(target, e);
        }
    }
}

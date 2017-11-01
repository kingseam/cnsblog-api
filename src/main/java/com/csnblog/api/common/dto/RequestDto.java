package com.csnblog.api.common.dto;

import lombok.Getter;

import java.util.Map;

@Getter
public class RequestDto<T> {
    private String version;
    private T param;
    private Map<String, Object> paramMap;
}

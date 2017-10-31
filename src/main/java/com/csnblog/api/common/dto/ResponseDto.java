package com.csnblog.api.common.dto;

import java.util.Collections;
import java.util.List;

/**
 * API Response 객체.
 * ok, fail Factory 메서드로만 생성가능. setter 미제공.
 * @param <T>
 */
public class ResponseDto<T> {
    private String code;
    private String message;
    private List<T> data;
    private static final ResponseDto<?> OK = new ResponseDto<>("200", "ok", Collections.emptyList());

    /**
     * data를 보유하지않는 응답형 DTO.
     * 상태가 변할여지가 없는 default 객체이므로 상수 반환.
     * @return
     */
    public static ResponseDto<?> ok(){
        return OK;
    }

    public static <T> ResponseDto<T> ok(List<T> data){
        return new ResponseDto<>("200", "ok", data);
    }

    public static <T> ResponseDto<T> ok(String code, String message, List<T> data){
        return new ResponseDto<>(code, message, data);
    }

    public static ResponseDto<?> fail(String code, String message){
        return new ResponseDto<>(code, message, Collections.emptyList());
    }

    private ResponseDto(String code, String message, List<T> data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }

    public List<T> getData(){
        return this.data;
    }
}

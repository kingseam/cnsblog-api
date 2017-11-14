package com.csnblog.api.common.dto;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import lombok.Getter;

@Getter
public class RequestDto<T> {
    private T param;
    private Map<String, Object> paramMap;

    @SuppressWarnings("unchecked")
    public <V> V get(String key){
        return (V) this.paramMap.get(key);
    }

    @SuppressWarnings("unchecked")
    public <V> V getOrDefault(String key, V v){
        Object result = this.paramMap.getOrDefault(key, v);
        return (V) result;
    }

    /**
     * param 이 null 일 경우 반환할 기본객체 반환
     * @param t
     * @return
     */
    public T getParamOrDefault(T t){
        return Optional.ofNullable(this.param)
                .orElse(t);
    }

    /**
     * param 이 null 일 경우 반환할 기본객체 반환
     * 객체 생성 비용이 클경우를 대비한 lazy 방식
     * @param supplier
     * @return
     */
    public T getParamOrDefaultGet(Supplier<T> supplier){
        return Optional.ofNullable(this.param)
                .orElseGet(supplier);
    }
}

package com.csnblog.api.common.dto;

import lombok.Getter;

import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

@Getter
public class RequestDto {
    private Map<String, Object> param;

    @SuppressWarnings("unchecked")
    public <V> V get(String key){
        return (V) this.param.get(key);
    }

    @SuppressWarnings("unchecked")
    public <V> V getOrDefault(String key, V v){
        Object result = this.param.getOrDefault(key, v);
        return (V) result;
    }

    @SuppressWarnings("unchecked")
    public <V> V getOrDefaultLazy(String key, Supplier<V> supplier){
        Object result = this.param.get(key);

        return Objects.isNull(result) ? supplier.get() : (V) result;
    }

    public <V> V get(String key, Class<V> genericClass){
        return genericClass.cast(this.param.get(key));
    }

    public <V> V getOrDefault(String key, Class<V> genericClass, V v){
        Object result = this.param.getOrDefault(key, v);
        return genericClass.cast(result);
    }

    public <V> V getOrDefaultLazy(String key, Class<V> genericClass, Supplier<V> supplier){
        Object result = this.param.get(key);

        return Objects.isNull(result) ? supplier.get() : genericClass.cast(result);
    }

    // test를 위한 map 주입용 팩토리 메서드
    static RequestDto forTest(Map<String, Object> map){
        RequestDto dto = new RequestDto();
        dto.param = map;

        return dto;
    }
}

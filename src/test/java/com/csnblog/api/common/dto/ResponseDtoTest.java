package com.csnblog.api.common.dto;

import com.csnblog.api.common.enumclass.ResponseCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ResponseDtoTest {
    @Test
    public void default_create(){
        ResponseDto dto = new ResponseDto.Builder().build();

        assertThat(dto.getCode(), is(ResponseCode.SUCCESS));
    }

    @Test
    public void builder_create(){
        ResponseDto dto = new ResponseDto.Builder()
                .responseCode(ResponseCode.SUCCESS)
                .data("data1", new Person("name", 29))
                .data("data2", new Person1("data2", 29))
                .data("collection", Arrays.asList(new Person("collection", 29)))
                .build();

        Person data1 = new Person("name", 29);
        Person1 data2 = new Person1("data2", 29);
        Person element = new Person("collection", 29);

        Map<String, Object> resultMap = dto.getData();

        assertThat(resultMap.get("data1"), is(data1));
        assertThat(resultMap.get("data2"), is(data2));
        assertThat(resultMap.get("collection"), is(Arrays.asList(element)));
    }

    @Test
    public void toJson() throws Exception {
        ResponseDto dto = new ResponseDto.Builder().build();

        ObjectMapper mapper = new ObjectMapper();

        String jsonResult = mapper.writeValueAsString(dto);

        assertThat(jsonResult, is("{\"code\":{\"code\":\"0000\",\"message\":\"success\"},\"data\":{}}"));
    }

    @EqualsAndHashCode
    @AllArgsConstructor
    private static class Person{
        private String name;
        private int age;
    }

    @EqualsAndHashCode
    @AllArgsConstructor
    private static class Person1{
        private String name;
        private int age;
    }
}
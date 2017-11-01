package com.csnblog.api.common.dto;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.csnblog.api.common.enumclass.ResponseCode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

public class ResponseDtoTest {
    @Test
    public void default_create(){
        ResponseDto dto = new ResponseDto.Builder().build();

        assertThat(dto.getCode(), is(ResponseCode.SUCCESS));
    }

    @Test
    public void builder_create(){
        ResponseDto dto = new ResponseDto.Builder().useResFail().build();

//        Person data1 = new Person("name", 29);
//        Person1 data2 = new Person1("data2", 29);
//        Person element = new Person("collection", 29);
//
//        Map<String, Object> resultMap = dto.getData();
//
//        assertThat(resultMap.get("data1"), is(data1));
//        assertThat(resultMap.get("data2"), is(data2));
//        assertThat(resultMap.get("collection"), is(Arrays.asList(element)));
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
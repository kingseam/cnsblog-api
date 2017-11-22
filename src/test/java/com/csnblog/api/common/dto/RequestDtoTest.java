package com.csnblog.api.common.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RequestDtoTest {
    private RequestDto dto;

    @Before
    public void setUp(){
        Person person = new Person("LichKing", 29);

        Map<String, Object> map = new HashMap<>();
        map.put("int", 500);
        map.put("string", "hello");
        map.put("person", person);

        this.dto = RequestDto.forTest(map);
    }

    @Test
    public void cast_primitive(){
        int number = this.dto.get("int");

        assertThat(number, is(500));
    }

    @Test
    public void cast_string(){
        String string = this.dto.get("string");

        assertThat(string, is("hello"));
    }

    @Test
    public void cast_object(){
        // given
        Person expected = new Person("LichKing", 29);

        // when
        Person actually = this.dto.get("person");

        // then
        assertThat(actually, is(expected));
    }

    @Test
    public void cast_primitive_generic(){
        int number = this.dto.get("int", Integer.class);

        assertThat(number, is(500));
    }

    @Test
    public void cast_string_generic(){
        String string = this.dto.get("string", String.class);

        assertThat(string, is("hello"));
    }

    @Test
    public void cast_object_generic(){
        // given
        Person expected = new Person("LichKing", 29);

        // when
        Person actually = this.dto.get("person", Person.class);

        // then
        assertThat(actually, is(expected));
    }

    @Test(expected = ClassCastException.class)
    public void cast_exception_primitive(){
        int number = this.dto.get("string");
    }

    @Test(expected = ClassCastException.class)
    public void cast_exception_string(){
        String string = this.dto.get("int", String.class);
    }

    @EqualsAndHashCode
    @AllArgsConstructor
    private static class Person{
        private String name;
        private int age;
    }
}
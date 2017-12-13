package com.cnsblog.api.common.utils;

import com.cnsblog.api.common.exception.JsonException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class JsonUtilsTest {
    @Test
    public void toJson(){
        // given
        Person target = new Person(29, "changyong");

        // when
        String actual = JsonUtils.toJson(target);

        // then
        String expect = "{\"age\":29,\"name\":\"changyong\"}";
        assertThat(actual, is(expect));
    }

    @Test
    public void fromJson(){
        // given
        String target = "{\"age\":29,\"name\":\"changyong\"}";

        // when
        Person actual = JsonUtils.fromJson(target, Person.class);

        // then
        Person expect = new Person(29, "changyong");
        assertThat(actual, is(expect));
    }

    @Test(expected = JsonException.class)
    public void fromJson_exception(){
        // given
        String target = "{\"person\":29}";

        // when
        JsonUtils.fromJson(target, Person.class);
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    private static class Person{
        private int age;
        private String name;
    }
}
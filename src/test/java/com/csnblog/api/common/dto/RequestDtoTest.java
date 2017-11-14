package com.csnblog.api.common.dto;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.nullValue;

import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

public class RequestDtoTest {
    @Test
    public void deserialize() throws Exception {
        String target = "{\"version\":\"v10.0\"}";

        ObjectMapper mapper = new ObjectMapper();

        RequestDto<?> dto = mapper.readValue(target, RequestDto.class);

        assertThat(dto.getParam(), is(nullValue()));
    }

    @Test
    public void deserialize_generic() throws Exception {
        String target = "{\"version\":\"v10.0\",\"param\":{\"name\":\"name\",\"age\":29}}";

        ObjectMapper mapper = new ObjectMapper();
        RequestDto<Person> dto = mapper.readValue(target, new TypeReference<RequestDto<Person>>(){});

        Person expect = new Person("name", 29);

        assertThat(dto.getParam(), instanceOf(Person.class));
        assertThat(dto.getParam(), is(expect));
    }

    @Test
    public void deserialize_paramMap() throws Exception {
        String target = "{\"version\":\"v10.0\",\"paramMap\":{\"name\":\"name\",\"age\":29}}";

        ObjectMapper mapper = new ObjectMapper();
        RequestDto<?> dto = mapper.readValue(target, RequestDto.class);

        Map<String, Object> map = dto.getParamMap();

        assertThat(map.get("name"), is("name"));
        assertThat(map.get("age"), is(29));
    }

    @EqualsAndHashCode
    @AllArgsConstructor
    private static class Person{
        private String name;
        private int age;
    }
}
package com.csnblog.api.common.dto;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ResponseDtoTest {

    @Test
    public void 성공_객체_동일성_비교(){
        ResponseDto dto1 = ResponseDto.ok();
        ResponseDto dto2 = ResponseDto.ok();

        assertTrue(dto1 == dto2);
    }

    @Test
    public void ok_메서드(){
        ResponseDto<Person> dto = ResponseDto.ok(Arrays.asList(new Person("name", 29)));
        Person result = dto.getData().get(0);
        Person expect = new Person("name", 29);

        assertThat(result, is(expect));
    }

    private static class Person{
        private String name;
        private int age;

        Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (age != person.age) return false;
            return name != null ? name.equals(person.name) : person.name == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }
    }
}
package com.csnblog.api.common.dto;

import lombok.Data;

import java.util.Optional;

@Data
public class Person implements Completable<Person> {
    private int age;
    private String name;

    @Override
    public Person getComplete() {
        Person person = new Person();
        // age 필드의 기본값이 10이라 가정
        // 기본타입은 null이 들어가지못하고 0으로 초기화됨으로 0이면 값이 안들어온것
        person.age = this.age == 0 ? 10 : this.age;
        person.name = Optional.ofNullable(this.name)
                .orElse("");

        return person;
    }
}

package com.cnsblog.api.web.domain;

import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Map;

@Data
public class User {
    private String user_name;
    private String password;
    private String user_type;

    public static User of(Map<String, Object> map){
        User user = new User();

        user.user_name = String.valueOf(map.get("user_name"));
        user.password = new BCryptPasswordEncoder().encode(String.valueOf(map.get("password")));
        user.user_type = String.valueOf(map.get("user_type"));

        return user;
    }
}
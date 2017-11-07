package com.csnblog.api.web.domain;

import lombok.Data;

@Data
public class User {
    private String user_name;
    private String password;
    private String user_type;
}
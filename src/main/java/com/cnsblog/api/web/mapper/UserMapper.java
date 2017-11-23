package com.cnsblog.api.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.cnsblog.api.web.domain.User;

@Repository
@Mapper
public interface UserMapper {
	int insertUser(User user);
    int getExistUser(String name);
}
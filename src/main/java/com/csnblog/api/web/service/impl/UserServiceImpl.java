package com.csnblog.api.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csnblog.api.web.domain.User;
import com.csnblog.api.web.mapper.UserMapper;
import com.csnblog.api.web.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Transactional
	@Override
	public boolean insertUser(User user) {
		int result = userMapper.getExistUser(user.getUser_name());

		if(result == 0){
			userMapper.insertUser(user);
			return true;
		}

		return false;
	}
}

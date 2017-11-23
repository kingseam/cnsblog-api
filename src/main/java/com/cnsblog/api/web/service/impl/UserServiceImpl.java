package com.cnsblog.api.web.service.impl;

import com.cnsblog.api.web.domain.User;
import com.cnsblog.api.web.mapper.UserMapper;
import com.cnsblog.api.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	private final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

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

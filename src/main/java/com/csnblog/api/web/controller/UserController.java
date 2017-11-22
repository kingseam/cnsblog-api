package com.csnblog.api.web.controller;

import com.csnblog.api.common.dto.RequestDto;
import com.csnblog.api.common.dto.ResponseDto;
import com.csnblog.api.common.enumclass.ResponseCode;
import com.csnblog.api.web.domain.User;
import com.csnblog.api.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController extends BaseController {

	private final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userSerivce;

	@PutMapping("/users")
	public @ResponseBody ResponseDto insertUser(@RequestBody RequestDto reqDto){
		ResponseDto resDto = new ResponseDto.Builder().build();
//		LOG.info("users reqDto = {}", reqDto.getParam());
		LOG.info("users reqDto = {}", reqDto.getParam());
		// password crypt
		User user = User.of(reqDto.getParam());
//		reqDto.getParam().setPassword(new BCryptPasswordEncoder().encode(reqDto.getParam().getPassword()));

		if(!userSerivce.insertUser(user)){
			return new ResponseDto.Builder(ResponseCode.EXIST_USER).build();
		}

		return resDto;
	}
}

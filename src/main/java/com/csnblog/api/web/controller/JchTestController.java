package com.csnblog.api.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jch")
public class JchTestController {

	@RequestMapping("")
	public String commitTest() {
		
		return "ChoelHoJung, commit push test";
	}
}

package com.csnblog.api.web.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping(value = "/")
    public String app() {
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
		System.out.println(((List)SecurityContextHolder.getContext().getAuthentication().getAuthorities()).get(0));
		System.out.println(SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
        return "CNS BLOG :: API";
    }

	@GetMapping(value = "/simple/test")
    public String test() {
        return "CNS BLOG :: API22";
    }

	@GetMapping(value = "/anonymous")
    public String anonymous() {
        return "CNS BLOG :: API";
    }

	@GetMapping(value = "/api/test")
    public String anonymous2() {
        return "CNS BLOG :: API";
    }
}

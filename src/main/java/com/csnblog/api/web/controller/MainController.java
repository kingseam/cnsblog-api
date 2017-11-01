package com.csnblog.api.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping(value = "/")
    public String app() {
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

package com.csnblog.api.web.controller;


import com.csnblog.api.web.domain.Sample;
import com.csnblog.api.web.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/sample")
public class SampleController {

    private final SampleService sampleService;

    @Autowired
    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/list")
    public Sample sampleController() throws IOException {
        return sampleService.getSampleList();
    }
}

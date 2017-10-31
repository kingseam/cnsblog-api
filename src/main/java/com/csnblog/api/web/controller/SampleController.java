package com.csnblog.api.web.controller;


import com.csnblog.api.common.constant.ResponseAttribute;
import com.csnblog.api.web.controller.template.JsonResponseTemplate;
import com.csnblog.api.web.domain.Sample;
import com.csnblog.api.web.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sample")
public class SampleController {

    private final SampleService sampleService;

    @Autowired
    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }


    @GetMapping("/list")
    public String sampleController() throws IOException {
        Map responseResult = new HashMap();
        JsonResponseTemplate jsonResponseTemplate = new JsonResponseTemplate(responseResult) {
            @Override
            public void doJob() throws IOException {

                Sample sampleResultData = sampleService.getSampleList();

                responseResult.put(ResponseAttribute.RESULTS, sampleResultData);
            }
        };
        return jsonResponseTemplate.getResultArrayJson();
    }
}

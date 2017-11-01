package com.csnblog.api.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csnblog.api.common.constant.ResponseAttribute;
import com.csnblog.api.common.dto.ResponseDto;
import com.csnblog.api.common.enumclass.ResponseCode;
import com.csnblog.api.web.controller.template.JsonResponseTemplate;
import com.csnblog.api.web.domain.Sample;
import com.csnblog.api.web.service.SampleService;
import com.google.common.collect.Maps;

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

	@GetMapping("/list2")
	public @ResponseBody ResponseDto sample2Controller() {
		Map<String, Object> result = Maps.newHashMap();

		if ("로그인".equals("로긴")) {
			return new ResponseDto.Builder().useResFail(ResponseCode.FAIL).build();
		}

		Sample sampleResultData = sampleService.getSampleList();
		result.put("sampleResultData", sampleResultData);

		return new ResponseDto.Builder(result).build();

	}

	@GetMapping("/list3")
	public @ResponseBody ResponseDto sample3Controller() {
		ResponseDto resDto = new ResponseDto.Builder().build();

		if ("로그인".equals("로긴")) {
			return new ResponseDto.Builder().useResFail(ResponseCode.FAIL).build();
		}

		Sample sampleResultData = sampleService.getSampleList();
		resDto.getData().put("sampleResultData", sampleResultData);

		return resDto;

	}
}

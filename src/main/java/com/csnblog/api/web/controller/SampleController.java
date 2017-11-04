package com.csnblog.api.web.controller;

import com.csnblog.api.common.constant.ResponseAttribute;
import com.csnblog.api.common.dto.RequestDto;
import com.csnblog.api.common.dto.ResponseDto;
import com.csnblog.api.common.enumclass.ResponseCode;
import com.csnblog.api.web.controller.template.JsonResponseTemplate;
import com.csnblog.api.web.domain.Sample;
import com.csnblog.api.web.service.SampleService;
import com.google.common.collect.Maps;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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

	@PostMapping("/request")
	public @ResponseBody ResponseDto sampleRequestController(@RequestBody RequestDto<Person> dto){
		Map<String, Object> map = new HashMap<>();
		map.put("check", dto.getParam() instanceof Person);
		return new ResponseDto.Builder(map).build();
	}

	@PostMapping("/request/collection")
	public @ResponseBody ResponseDto sampleRequestCollectionController(@RequestBody RequestDto<PersonWrapper> dto){
		Map<String, Object> map = new HashMap<>();
		map.put("outerCheck", dto.getParam() instanceof PersonWrapper);
		map.put("innerCheck", dto.getParam().getPersons().get(0) instanceof Person);
		return new ResponseDto.Builder(map).build();
	}

	@Data
	public static class Person{
		private String name;
		private int age;
	}

	@Data
	public static class PersonWrapper{
		private List<Person> persons;
	}
}

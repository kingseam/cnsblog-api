package com.cnsblog.api.web.controller;

import com.cnsblog.api.common.dto.ResponseDto;
import com.cnsblog.api.web.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class BoardController extends BaseController {

	private final Logger LOG = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardSerivce;

	@GetMapping("/board")
	public @ResponseBody
    ResponseDto getAll(){
		ResponseDto resDto = new ResponseDto.Builder().build();
		resDto.getData().put("result", boardSerivce.getAllBoardList());
		return resDto;
	}

	@GetMapping("/board/{id}")
	public @ResponseBody ResponseDto getOne(@PathVariable("id") int id){
		ResponseDto resDto = new ResponseDto.Builder().build();
		resDto.getData().put("result", boardSerivce.getBoardDetail(id));
		return resDto;
	}
}

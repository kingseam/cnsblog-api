package com.csnblog.api.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csnblog.api.common.dto.ResponseDto;
import com.csnblog.api.web.service.BoardService;

@CrossOrigin
@RestController
@RequestMapping("/board")
public class BoardController extends BaseController {

	private final Logger LOG = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardSerivce;

	@GetMapping("/list")
	public @ResponseBody ResponseDto listAll(){
		ResponseDto resDto = new ResponseDto.Builder().build();
		resDto.getData().put("list", boardSerivce.getAllBoardList());
		return resDto;
	}

	@GetMapping("/list/{id}")
	public @ResponseBody ResponseDto list(@PathVariable("id") int id){
		ResponseDto resDto = new ResponseDto.Builder().build();
		resDto.getData().put("list", boardSerivce.getBoardList(id));
		return resDto;
	}
}

package com.csnblog.api.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csnblog.api.web.domain.Board;
import com.csnblog.api.web.mapper.BoardMapper;
import com.csnblog.api.web.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public Board getBoardDetail(int id) {
		return boardMapper.getBoardDetail(id);
	}

	@Override
	public List<Board> getBoardList(int id) {
		return boardMapper.getBoardList(id);
	}

	@Override
	public List<Board> getAllBoardList() {
		return boardMapper.getAllBoardList();
	}
}

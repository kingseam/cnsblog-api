package com.cnsblog.api.web.service.impl;

import java.util.List;

import com.cnsblog.api.web.mapper.BoardMapper;
import com.cnsblog.api.web.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnsblog.api.web.domain.Board;

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

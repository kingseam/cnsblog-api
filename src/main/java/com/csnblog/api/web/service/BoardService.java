package com.csnblog.api.web.service;

import java.util.List;

import com.csnblog.api.web.domain.Board;

public interface BoardService {

	Board getBoardDetail(int id);
    List<Board> getBoardList(int id);
    List<Board> getAllBoardList();
}

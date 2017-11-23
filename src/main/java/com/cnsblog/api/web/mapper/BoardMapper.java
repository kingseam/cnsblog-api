package com.cnsblog.api.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.cnsblog.api.web.domain.Board;

@Repository
@Mapper
public interface BoardMapper {
	Board getBoardDetail(int id);
    List<Board> getBoardList(int id);
    List<Board> getAllBoardList();
}
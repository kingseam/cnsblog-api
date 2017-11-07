package com.csnblog.api.web.domain;

import lombok.Data;

@Data
public class Board {
    private int boardId;
    private int boardPid;
    private String userId;
    private String userName;
    private String subject;
    private String contents;
    private int hits;
    private String regDate;
}
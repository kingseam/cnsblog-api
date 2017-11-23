package com.cnsblog.api.web.domain;

import lombok.Data;

@Data
public class Board {
    private int board_id;
    private int board_pid;
    private String user_id;
    private String user_name;
    private String subject;
    private String contents;
    private int hits;
    private String reg_date;
}
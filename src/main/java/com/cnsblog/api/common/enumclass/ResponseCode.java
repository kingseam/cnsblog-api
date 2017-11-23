package com.cnsblog.api.common.enumclass;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum ResponseCode {
    SUCCESS("0000", "success"),
    DEFAULT("0000", "success"),
    EXIST_USER("1000", "해당 아이디가 있습니다."),
	FAIL("9999", "file");

    private final String code;
    private final String message;
}

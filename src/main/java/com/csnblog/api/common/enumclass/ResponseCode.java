package com.csnblog.api.common.enumclass;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum ResponseCode {
    SUCCESS("0000", "success"),
    DEFAULT("0000", "success"),
	FAIL("9999", "file");

    private final String code;
    private final String message;
}

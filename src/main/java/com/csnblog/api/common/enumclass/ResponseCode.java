package com.csnblog.api.common.enumclass;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum ResponseCode {
    // 임시 성공 코드
    SUCCESS("0000", "success");

    private final String code;
    private final String message;
}

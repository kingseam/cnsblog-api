package com.csnblog.api.common.dto;

import com.csnblog.api.common.enumclass.ResponseCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ResponseDto {
    private ResponseCode code;
    private Map<String, Object> data;

    public static class Builder {
        private ResponseCode code;
        private Map<String, Object> data;

        public Builder() {
            this.data = new HashMap<>();
        }

        public Builder responseCode(ResponseCode code) {
            this.code = code;
            return this;
        }

        public Builder data(String key, Object value) {
            this.data.put(key, value);

            return this;
        }

        public ResponseDto build() {
            ResponseDto dto = new ResponseDto();
            dto.code = Optional.ofNullable(this.code)
                                .orElse(ResponseCode.SUCCESS);
            dto.data = this.data;

            return dto;
        }
    }
}

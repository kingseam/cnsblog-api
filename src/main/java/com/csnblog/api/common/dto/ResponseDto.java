package com.csnblog.api.common.dto;

import java.util.Map;

import com.csnblog.api.common.enumclass.ResponseCode;

import lombok.Getter;

@Getter
public class ResponseDto {
    private ResponseCode code;
    private Map<String, Object> data;

    private ResponseDto(Builder builder) {
		this.code = builder.code;
		this.data = builder.data;
	}

    public static class Builder {
        private ResponseCode code;
        private Map<String, Object> data;

        public Builder() {
        	code = ResponseCode.DEFAULT;
        	data = null;
		}

        public Builder(ResponseCode code) {
        	this.code = code;
		}

        public Builder(Map<String, Object> data) {
        	this.data = data;
		}

        public Builder(ResponseCode code, Map<String, Object> data) {
        	this.code = code;
        	this.data = data;
		}

        public Builder useResFail() {
        	this.code = ResponseCode.FAIL;
        	return this;
        }

        public Builder useResFail(ResponseCode code) {
        	this.code = code;
	        return this;
	    }

        public Builder useResData(Map<String, Object> data){
        	this.data = data;
        	return this;
        }

    }
}

package com.cnsblog.api.common.dto;

import java.util.Map;

import com.cnsblog.api.common.enumclass.ResponseCode;
import com.google.common.collect.Maps;

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
			data = Maps.newHashMap();
		}

		public Builder(ResponseCode code) {
			this.code = code;
			data = Maps.newHashMap();
		}

		public Builder(Map<String, Object> data) {
			this.code = ResponseCode.DEFAULT;
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

		public ResponseDto build() {
			return new ResponseDto(this);
		}

	}
}

package com.cnsblog.api.web.controller.template;

import com.cnsblog.api.common.APIErrorException;
import com.cnsblog.api.common.constant.ResponseAttribute;
import com.cnsblog.api.common.constant.ResponseCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public abstract class JsonResponseTemplate {

    private static final Logger log = LoggerFactory.getLogger(JsonResponseTemplate.class);  //todo logBack

    private final ObjectMapper mapper = new ObjectMapper();
    private Map<String, Object> responseResult;

    public JsonResponseTemplate(Map<String, Object> result) {
        responseResult = result;
    }

    public abstract void doJob() throws Exception;


    public String getResultArrayJson() throws IOException {

        try {
            doJob();
            responseResult.put(ResponseAttribute.SERVER_CODE.getCode(), ResponseCode.OK.getCode());
            responseResult.put(ResponseAttribute.SERVER_MSG.getCode(), ResponseCode.OK.getMessage());
        } catch (APIErrorException e) {

            log.error("JsonResponseTemplate APIErrorException :::: " + e.getErrorMsg() + "["+ e.getErrorCode() + "]", e);
            responseResult.put(ResponseAttribute.SERVER_CODE.getCode(), ResponseCode.OK.getCode());
            responseResult.put(ResponseAttribute.ERROR_CODE.getCode(), e.getErrorCode());
            responseResult.put(ResponseAttribute.ERROR_CODE_MSG.getCode(), e.getErrorMsg());
        } catch (Exception e) {

            log.error("JsonResponseTemplate Exception :::: ", e);
            responseResult.put(ResponseAttribute.SERVER_CODE.getCode(), ResponseCode.OK.getCode());
            responseResult.put(ResponseAttribute.ERROR_CODE.getCode(), ResponseCode.SYSTEM_ERROR.getCode());
            responseResult.put(ResponseAttribute.ERROR_CODE_MSG.getCode(), e.getMessage());
        }

        return mapper.writeValueAsString(responseResult);

    }
}

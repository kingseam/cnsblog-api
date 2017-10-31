package com.csnblog.api.common.constant;

public enum ResponseCode {

    /** 정상 케이스인 경우 (200, "Reserved") */
    OK("200", "API : success Reserved"),

    /** 시스템 에러 (600, "System error") */
    SYSTEM_ERROR("600", "API : System error"),

    /** Incorrect API Key 인증키 에러 (601, "Incorrect API Key") */
    INCORRECT_API_KEY("601", "Incorrect API Key"),

    /** 허가 되지 않은 API 키 (602, "Unauthorized API Key") */
    UNAUTHORIZED_API_KEY("602", "Unauthorized API Key"),

    /** 파라메터를 잘못보내서 에러가 날경우 (603, "Incorrect query request") */
    INCORRECT_QUERY_REQUEST("603", "Incorrect query request"),

    /** URL 잘못 호출할경우 ("604", "Not found URL") */
    NOT_FOUND_URL("604", "Not found URL"),

    /** 인증되지 않은 호출방식(ex:get, post, put) ("605", "Method not allowed") */
    METHOD_NOT_ALLOWED("605", "Method not allowed"),

    /** INSERT 수행 실패시 */
    EXECUTE_INSERT_FAIL("606", "Execute insert fail"),

    /** UPDATE 수행 실패시 */
    EXECUTE_UPDATE_FAIL("607", "Execute update fail"),

    /** DELETE 수행 실패시 */
    EXECUTE_DELETE_FAIL("608", "Execute delete fail"),

    /** Data가 없을 경우 */
    NOT_FOUND_DATA("609", "Not Found Data");

    private String code;
    private String message;

    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}

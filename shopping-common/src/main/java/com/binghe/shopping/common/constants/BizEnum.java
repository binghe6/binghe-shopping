package com.binghe.shopping.common.constants;

/**
 * 业务枚举
 * @author dongsw
 *
 */
public enum BizEnum {
	SUCCESS(2000, "成功"),
    SYSTEM_ERROR(5000, "系统异常");
    
	public int code;
    public String message;

    private BizEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

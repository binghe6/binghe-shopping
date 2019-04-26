package com.binghe.shopping.common.bean.resp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.binghe.shopping.common.constants.BizEnum;

/**
 * 通用的返回格式
 * @author dongsw
 *
 */
public class CommonResp {

	private CommonResp() {}
    private int code;
    private String message;
    private Object data = new HashMap<String,Object>();

    public static CommonResp success() {
        CommonResp response = new CommonResp();
        response.code = BizEnum.SUCCESS.code;
        response.message = BizEnum.SUCCESS.message;
        return response;
    }

    public static CommonResp success(Object data) {
        CommonResp response = new CommonResp();
        response.code = BizEnum.SUCCESS.code;
        response.message = BizEnum.SUCCESS.message;
        response.data = data == null ? new HashMap<String,Object>() : data;
        return response;
    }
    
    public static CommonResp success(String key,List<?> data) {
    	Map<String,Object> map =  new HashMap<String,Object>();
    	map.put(key, data);
		return CommonResp.success(map);
    }

    public static CommonResp errorMessage(int code ,String message) {
    	 CommonResp response = new CommonResp();
    	 response.setCode(code);
    	 response.setMessage(message);
		return response;
    }

    public static CommonResp error(BizEnum BizEnum) {
        CommonResp response = new CommonResp();
        response.code = BizEnum.code;
        response.message = BizEnum.message;
        return response;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

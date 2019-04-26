package com.binghe.shopping.manage.web;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.binghe.shopping.common.bean.resp.CommonResp;
import com.binghe.shopping.common.constants.BizEnum;
import com.binghe.shopping.common.exception.BizException;

@Slf4j
@ControllerAdvice
public class BaseController {
	@ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResp exceptionHandler(Exception e) {
        e.printStackTrace();
        log.error("system exception>>>>>>>>>>>>>>>>>>>>>>>>>>", e);
        return CommonResp.error(BizEnum.SYSTEM_ERROR);
    }

    @ExceptionHandler(BizException.class)
    @ResponseBody
    public CommonResp exceptionHandler(BizException e) {
        log.error("business exception>>>>>>>>>>>>>>>>>>>>>>>>>> code:{} || message:{}",e.getBizEnum().code,e.getBizEnum().message, e);
        return CommonResp.error(e.getBizEnum());
    }
}

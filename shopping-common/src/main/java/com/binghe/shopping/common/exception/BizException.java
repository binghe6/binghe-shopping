package com.binghe.shopping.common.exception;

import com.binghe.shopping.common.constants.BizEnum;

public class BizException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3397213188448947447L;
	private BizEnum bizEnum;

    public BizException() {}

    public BizException(String message) {
        super(message);
    }

    public BizException(BizEnum bizEnum) {
        this.bizEnum = bizEnum;
    }

	public BizEnum getBizEnum() {
		return bizEnum;
	}

	public void setBizEnum(BizEnum bizEnum) {
		this.bizEnum = bizEnum;
	}

}

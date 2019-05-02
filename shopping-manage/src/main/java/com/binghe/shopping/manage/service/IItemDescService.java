package com.binghe.shopping.manage.service;

import com.binghe.shopping.common.bean.resp.CommonResp;

public interface IItemDescService {
	
	/**
	 * 通过商品ID查询商品描述
	 * @param itemId
	 * @return
	 */
	CommonResp getItemDescByItemId(long itemId);

}

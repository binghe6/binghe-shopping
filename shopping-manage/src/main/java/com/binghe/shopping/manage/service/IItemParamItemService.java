package com.binghe.shopping.manage.service;

import com.binghe.shopping.common.bean.resp.CommonResp;

public interface IItemParamItemService {

	/**
	 * 根据商品ID查询商品规格
	 * @param itemId
	 * @return
	 */
	CommonResp getItemParamItemByItemId(long itemId);
}

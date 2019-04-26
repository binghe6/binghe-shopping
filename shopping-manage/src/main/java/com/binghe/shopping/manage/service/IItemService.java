package com.binghe.shopping.manage.service;

import com.binghe.shopping.common.bean.resp.CommonResp;
import com.binghe.shopping.manage.pojo.BaseItem;

public interface IItemService {

	/**
	 * 添加商品
	 * @param item
	 * @param itemDesc
	 * @return
	 */
	CommonResp addItem(BaseItem item, String itemDesc);

}

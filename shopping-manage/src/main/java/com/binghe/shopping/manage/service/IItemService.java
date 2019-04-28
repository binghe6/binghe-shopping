package com.binghe.shopping.manage.service;

import com.binghe.shopping.common.bean.resp.CommonResp;
import com.binghe.shopping.common.bean.resp.EasyUIResp;
import com.binghe.shopping.manage.pojo.BaseItem;

public interface IItemService {

	/**
	 * 添加商品
	 * @param item
	 * @param itemDesc
	 * @return
	 */
	CommonResp addItem(BaseItem item, String itemDesc);

	/**
	 * 分页查询商品列表
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIResp listItem(int page, int rows);

}

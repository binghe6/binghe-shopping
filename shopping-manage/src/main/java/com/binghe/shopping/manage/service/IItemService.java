package com.binghe.shopping.manage.service;

import java.util.List;

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
	CommonResp addItem(BaseItem item, String itemDesc, String itemParams);

	/**
	 * 分页查询商品列表
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIResp listItem(int page, int rows);

	/**
	 * 编辑商品
	 * @param item
	 * @param itemDesc
	 * @return
	 */
	CommonResp editItem(BaseItem item, String itemDesc, String itemParams);

	/**
	 * 根据商品ID删除商品
	 * @param ids
	 * @return
	 */
	CommonResp deleteItemByIds(List<Long> ids);

	/**
	 * 下架商品
	 * @param ids
	 * @return
	 */
	CommonResp instockItemByIds(List<Long> ids);

	/**
	 * 上架商品
	 * @param ids
	 * @return
	 */
	CommonResp reshelfItemByIds(List<Long> ids);

}

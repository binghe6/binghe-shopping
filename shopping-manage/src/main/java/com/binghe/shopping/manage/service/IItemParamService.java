package com.binghe.shopping.manage.service;

import java.util.List;

import com.binghe.shopping.common.bean.resp.CommonResp;
import com.binghe.shopping.common.bean.resp.EasyUIResp;

public interface IItemParamService {

	/**
	 * 分页查询产品规格
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIResp listItemParam(int page, int rows);

	/**
	 * 根据商品类目ID查询商品规格
	 * @param itemCatId
	 * @return
	 */
	CommonResp getItemParamByItemCatId(long itemCatId);

	/**
	 * 添加商品规格模版
	 * @param paramData
	 * @return
	 */
	CommonResp addItemParam(String paramData, long cid);


	/**
	 * 删除商品规格模版
	 * @param ids
	 * @return
	 */
	CommonResp deleteItemParamByIds(List<Long> ids);

}

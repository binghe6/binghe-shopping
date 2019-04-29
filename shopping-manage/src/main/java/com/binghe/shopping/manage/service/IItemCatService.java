package com.binghe.shopping.manage.service;

import java.util.List;

import com.binghe.shopping.common.bean.resp.CommonResp;
import com.binghe.shopping.manage.pojo.BaseItemCat;

public interface IItemCatService {

	/**
	 * 通过父类目ID查询商品类目
	 * @param parentId
	 * @return
	 */
	List<BaseItemCat> listItemCatByParentId(Long parentId);

	/**
	 * 根据商品ID获取商品类目
	 * @param itemCatId
	 * @return
	 */
	CommonResp getItemCatByItemCatId(long itemCatId);

}

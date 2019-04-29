package com.binghe.shopping.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binghe.shopping.common.bean.resp.CommonResp;
import com.binghe.shopping.manage.dao.BaseItemCatMapper;
import com.binghe.shopping.manage.pojo.BaseItemCat;
import com.binghe.shopping.manage.service.IItemCatService;

@Service
public class ItemCatServiceImpl implements IItemCatService {

	@Autowired
	private BaseItemCatMapper itemCatMapper;
	
	@Override
	public List<BaseItemCat> listItemCatByParentId(Long parentId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("parent_id", parentId);
		param.put("status", BaseItemCat.STATE_ON);
		return itemCatMapper.listByParam(param);
	}

	@Override
	public CommonResp getItemCatByItemCatId(long itemCatId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", itemCatId);
		param.put("state", BaseItemCat.STATE_ON);
		BaseItemCat itemCat = itemCatMapper.getByParam(param);
		return CommonResp.success(itemCat);
	}

}

package com.binghe.shopping.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binghe.shopping.manage.dao.BaseItemCatMapper;
import com.binghe.shopping.manage.pojo.BaseItemCat;
import com.binghe.shopping.manage.service.IItemCatService;

@Service
public class ItemCatServiceImpl implements IItemCatService {

	@Autowired
	private BaseItemCatMapper baseItemCatMapper;
	
	@Override
	public List<BaseItemCat> listItemCatByParentId(Long parentId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("parent_id", parentId);
		param.put("state", BaseItemCat.STATE_ON);
		return baseItemCatMapper.listByParam(param);
	}

}

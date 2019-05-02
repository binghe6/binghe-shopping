package com.binghe.shopping.manage.service.impl;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binghe.shopping.common.bean.resp.CommonResp;
import com.binghe.shopping.manage.dao.BaseItemParamItemMapper;
import com.binghe.shopping.manage.pojo.BaseItemParamItem;
import com.binghe.shopping.manage.service.IItemParamItemService;

@Service
@Slf4j
public class ItemParamItemServiceImpl implements IItemParamItemService {

	@Autowired
	private BaseItemParamItemMapper itemParamItemMapper;
	
	@Override
	public CommonResp getItemParamItemByItemId(long itemId) {
		log.info("get itemParamItem, itemId:{}", itemId);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("item_id", itemId);
		BaseItemParamItem itemParamItem = itemParamItemMapper.getByParam(param);
		log.info("get itemParamItem success, itemId:{}, result:{}", itemId, itemParamItem);
		return CommonResp.success(itemParamItem);
	}
}

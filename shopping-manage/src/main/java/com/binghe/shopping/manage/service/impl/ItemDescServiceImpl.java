package com.binghe.shopping.manage.service.impl;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binghe.shopping.common.bean.resp.CommonResp;
import com.binghe.shopping.manage.dao.BaseItemDescMapper;
import com.binghe.shopping.manage.pojo.BaseItemDesc;
import com.binghe.shopping.manage.service.IItemDescService;

@Service
@Slf4j
public class ItemDescServiceImpl implements IItemDescService {

	@Autowired
	private BaseItemDescMapper itemDescMapper;
	
	@Override
	public CommonResp getItemDescByItemId(long itemId) {
		log.info("get item desc, itemId:{}", itemId);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("item_id", itemId);
		BaseItemDesc itemDesc = itemDescMapper.getByParam(param);
		log.info("get item desc success, itemDesc:{}", itemDesc);
		return CommonResp.success(itemDesc);
	}
}

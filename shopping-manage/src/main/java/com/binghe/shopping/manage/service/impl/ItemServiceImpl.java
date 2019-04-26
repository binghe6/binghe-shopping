package com.binghe.shopping.manage.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.binghe.shopping.common.bean.resp.CommonResp;
import com.binghe.shopping.manage.dao.BaseItemDescMapper;
import com.binghe.shopping.manage.dao.BaseItemMapper;
import com.binghe.shopping.manage.pojo.BaseItem;
import com.binghe.shopping.manage.pojo.BaseItemDesc;
import com.binghe.shopping.manage.service.IItemService;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private BaseItemMapper itemMapper;
	@Autowired
	private BaseItemDescMapper itemDescMapper;
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public CommonResp addItem(BaseItem item, String itemDesc) {
		Date now = new Date();
		item.setId(null)
			.setStatus(BaseItem.STATUS_ON)
			.setCreateTime(now)
			.setUpdateTime(now);
		itemMapper.insert(item);
		BaseItemDesc baseItemDesc = BaseItemDesc.of().setItemId(item.getId())
				.setItemDesc(itemDesc)
				.setCreateTime(now)
				.setUpdateTime(now);
		itemDescMapper.insert(baseItemDesc);
		return CommonResp.success();
	}

}

package com.binghe.shopping.manage.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.binghe.shopping.common.bean.resp.CommonResp;
import com.binghe.shopping.common.bean.resp.EasyUIResp;
import com.binghe.shopping.manage.dao.BaseItemDescMapper;
import com.binghe.shopping.manage.dao.BaseItemMapper;
import com.binghe.shopping.manage.pojo.BaseItem;
import com.binghe.shopping.manage.pojo.BaseItemDesc;
import com.binghe.shopping.manage.service.IItemService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
@Slf4j
public class ItemServiceImpl implements IItemService {

	@Autowired
	private BaseItemMapper itemMapper;
	@Autowired
	private BaseItemDescMapper itemDescMapper;
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public CommonResp addItem(BaseItem item, String itemDesc) {
		log.info("add item, item:{}, desc:{}", item, itemDesc);
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
		log.info("add item success, itemId:{}", item.getId());
		return CommonResp.success();
	}

	@Override
	public EasyUIResp listItem(int page, int rows) {
		log.info("list item, page:{}, rows:{}", page, rows);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("status_not", BaseItem.STATUS_DEL);// 查询没有删除的商品
		param.put("update_time_desc", 1);// 更新时间倒序
		Page<Object> resultPage = PageHelper.startPage(page, rows);
		List<BaseItem> itemList = itemMapper.listByParam(param);
		log.info("list item success, itemList:{}", itemList);
		return new EasyUIResp(resultPage.getTotal(), itemList);
	}

}

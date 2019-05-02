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
import com.binghe.shopping.manage.dao.BaseItemParamItemMapper;
import com.binghe.shopping.manage.pojo.BaseItem;
import com.binghe.shopping.manage.pojo.BaseItemDesc;
import com.binghe.shopping.manage.pojo.BaseItemParamItem;
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
	@Autowired
	private BaseItemParamItemMapper itemParamItemMapper;
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public CommonResp addItem(BaseItem item, String itemDesc, String itemParams) {
		log.info("add item, item:{}, desc:{}, itemParams:{}", item, itemDesc, itemParams);
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
		BaseItemParamItem itemParamItem = BaseItemParamItem.of().setItemId(item.getId())
			.setParamData(itemParams)
			.setCreateTime(now)
			.setUpdateTime(now);
		itemParamItemMapper.insert(itemParamItem);
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

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public CommonResp editItem(BaseItem item, String itemDesc, String itemParams) {
		log.info("edit item, item:{}, itemDesc:{}, itemParams:{}", item, itemDesc, itemParams);
		Date now = new Date();
		// 确保状态和创建时间不被篡改
		item.setStatus(null)
			.setCreateTime(null)
			.setUpdateTime(now);
		itemMapper.updateByPrimaryKeySelective(item);
		BaseItemDesc baseItemDesc = BaseItemDesc.of().setCreateTime(null)
			.setUpdateTime(now)
			.setItemDesc(itemDesc)
			.setItemIdWhere(item.getId());
		itemDescMapper.updateByPrimaryKeySelective(baseItemDesc);
		BaseItemParamItem itemParamItem = BaseItemParamItem.of().setItemId(item.getId())
			.setParamData(itemParams)
			.setUpdateTime(now);
		itemParamItemMapper.updateByPrimaryKeySelective(itemParamItem);
		log.info("edit item success, itemId:{}", item.getId());
		return CommonResp.success();
	}
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public CommonResp deleteItemByIds(List<Long> ids) {
		log.info("delete item, ids:{}", ids);
		// 逻辑删除，把状态改为删除
		Date now = new Date();
		for (Long id : ids) {
			// 删除商品
			BaseItem item = BaseItem.of().setId(id)
				.setStatus(BaseItem.STATUS_DEL)
				.setUpdateTime(now);
			itemMapper.updateByPrimaryKeySelective(item);
		}
		log.info("delete item success, ids:{}", ids);
		return CommonResp.success();
	}
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public CommonResp instockItemByIds(List<Long> ids) {
		log.info("instock item, ids:{}", ids);
		Date now = new Date();
		for (Long id : ids) {
			// 下架
			BaseItem item = BaseItem.of().setId(id)
				.setStatus(BaseItem.STATUS_OFF)
				.setUpdateTime(now);
			itemMapper.updateByPrimaryKeySelective(item);
		}
		log.info("instock item success, ids:{}", ids);
		return CommonResp.success();
	}
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public CommonResp reshelfItemByIds(List<Long> ids) {
		log.info("reshelf item, ids:{}", ids);
		Date now = new Date();
		for (Long id : ids) {
			// 上架
			BaseItem item = BaseItem.of().setId(id)
				.setStatus(BaseItem.STATUS_ON)
				.setUpdateTime(now);
			itemMapper.updateByPrimaryKeySelective(item);
		}
		log.info("reshelf item success, ids:{}", ids);
		return CommonResp.success();
	}

}

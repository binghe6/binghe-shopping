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
import com.binghe.shopping.manage.dao.BaseItemCatMapper;
import com.binghe.shopping.manage.dao.BaseItemParamMapper;
import com.binghe.shopping.manage.pojo.BaseItemCat;
import com.binghe.shopping.manage.pojo.BaseItemParam;
import com.binghe.shopping.manage.service.IItemParamService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
@Slf4j
public class ItemParamServiceImpl implements IItemParamService {

	@Autowired
	private BaseItemParamMapper itemParamMapper;
	@Autowired
	private BaseItemCatMapper itemCatMapper;
	
	@Override
	public EasyUIResp listItemParam(int page, int rows) {
		log.info("list item param, page:{}, rows:{}", page, rows);
		Map<String, Object> param = new HashMap<String, Object>();
		Page<Object> resultPage = PageHelper.startPage(page, rows);
		List<BaseItemParam> itemParamList = itemParamMapper.listByParam(param);
		log.info("list item param success, result:{}", itemParamList); 
		return new EasyUIResp(resultPage.getTotal(), itemParamList);
	}

	@Override
	public CommonResp getItemParamByItemCatId(long itemCatId) {
		log.info("get item param , itemCatId:{}", itemCatId);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("item_cat_id", itemCatId);
		BaseItemParam itemParam = itemParamMapper.getByParam(param);
		log.info("get item param, itemCatId:{}, result:{}", itemCatId, itemParam);
		return CommonResp.success(itemParam);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public CommonResp addItemParam(String paramData, long cid) {
		log.info("add item param, paramData:{}", paramData);
		// 查询商品类目名
		BaseItemCat itemCat = itemCatMapper.selectByPrimaryKey(cid);
		// 插入商品规格模版
		Date now = new Date();
		BaseItemParam itemParam = BaseItemParam.of().setItemCatId(cid)
			.setItemCatName(itemCat.getName())
			.setParamData(paramData)
			.setCreateTime(now)
			.setUpdateTime(now);
		itemParamMapper.insert(itemParam);
		log.info("add item param success, itemCatId:{}", cid);
		return CommonResp.success();
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public CommonResp deleteItemParamByIds(List<Long> ids) {
		log.info("delete itemParam, ids:{}", ids);
		for (Long id : ids) {
			itemParamMapper.deleteByPrimaryKey(id);
		}
		log.info("delete itemParam success, ids:{}", ids);
		return CommonResp.success();
	}

}

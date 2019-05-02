package com.binghe.shopping.manage.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.binghe.shopping.common.bean.resp.CommonResp;
import com.binghe.shopping.common.bean.resp.ItemCatData;
import com.binghe.shopping.common.bean.resp.ItemCatResult;
import com.binghe.shopping.manage.dao.BaseItemCatMapper;
import com.binghe.shopping.manage.pojo.BaseItemCat;
import com.binghe.shopping.manage.service.IItemCatService;

@Service
@Slf4j
public class ItemCatServiceImpl implements IItemCatService {

	@Autowired
	private BaseItemCatMapper itemCatMapper;
	
	@Override
	public List<BaseItemCat> listItemCatByParentId(Long parentId) {
		log.info("list itemCat, parentId:{}", parentId);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("parent_id", parentId);
		param.put("status", BaseItemCat.STATE_ON);
		List<BaseItemCat> itemCatList = itemCatMapper.listByParam(param);
		log.info("list itemCat success, parentId:{}, result:{}", parentId, itemCatList);
		return itemCatList;
	}

	@Override
	public CommonResp getItemCatByItemCatId(long itemCatId) {
		log.info("get itemCat, itemCatId:{}", itemCatId);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", itemCatId);
		param.put("state", BaseItemCat.STATE_ON);
		BaseItemCat itemCat = itemCatMapper.getByParam(param);
		log.info("get itemCat success, itemCatId:{}, result:{}", itemCatId, itemCat);
		return CommonResp.success(itemCat);
	}

	@Override
	public String listAllItemCat(String callback) {
		log.info("list all itemCat");
		// 查询所有商品类目
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("status", BaseItemCat.STATE_ON);
		param.put("sort_ordor_asc_name_asc", 1);// 先按排列序号排序，排列序号一样则按类目名排序
		List<BaseItemCat> itemCatList = itemCatMapper.listByParam(param);
		
		// 按父ID分类
		Map<Long, List<BaseItemCat>> itemCatMap = new HashMap<Long, List<BaseItemCat>>();
		for (BaseItemCat itemCat : itemCatList) {
			List<BaseItemCat> list = itemCatMap.get(itemCat.getParentId());
			if (list == null || list.size() == 0) {
				list = new ArrayList<BaseItemCat>();
			}
			list.add(itemCat);
			itemCatMap.put(itemCat.getParentId(), list);
		}
		
		// 获取底层类目
		List<BaseItemCat> topItemCats = itemCatMap.get(0L);
		List<ItemCatData> topItems = new ArrayList<ItemCatData>();
		for (BaseItemCat baseItemCat : topItemCats) {
			ItemCatData topItem = ItemCatData.of().setUrl(MessageFormat.format("/products/{0}.html", baseItemCat.getId()))
					.setName(MessageFormat.format("<a href='/products/"+baseItemCat.getId()+".html'>{0}</a>", baseItemCat.getName()));// 此处第一个不能用替换符，因为会被“/”防转义而替换失败
			
			if (baseItemCat.getParentFlag() == BaseItemCat.FLAG_IS_PARENT) {
				// 拿到第二层的类目集合
				List<BaseItemCat> secondItemCats = itemCatMap.get(baseItemCat.getId());
				List<ItemCatData> secondItems = new ArrayList<ItemCatData>();// 第二层数据
				for (BaseItemCat secondItemCat : secondItemCats) {
					ItemCatData secondItem = ItemCatData.of().setUrl(MessageFormat.format("/products/{0}.html", secondItemCat.getId()))
							.setName(secondItemCat.getName());
					if (secondItemCat.getParentFlag() == BaseItemCat.FLAG_IS_PARENT) {
						// 拿到最里层类目集合
						List<BaseItemCat> lowestItemCats = itemCatMap.get(secondItemCat.getId());
						List<String> lowestItems = new ArrayList<String>();// 最底层数据
						for (BaseItemCat lowestItemCat : lowestItemCats) {
							// 组装最底层数据
							lowestItems.add(MessageFormat.format("/products/"+lowestItemCat.getId()+".html|{0}", lowestItemCat.getName()));// 此处第一个不能用替换符，因为会被“/”防转义而替换失败
						}
						secondItem.setItems(lowestItems);
					}
					
					// 组装第二层数据
					secondItems.add(secondItem);
				}
				
				topItem.setItems(secondItems);
			}
			
			// 封装最外层数据
			topItems.add(topItem);
			
			if (topItems.size() >= 14) {
				break;
			}
		}
		
		String result = JSON.toJSONString(ItemCatResult.of().setItemCats(topItems));
		log.info("list all itemCat success, result:{}", result);
		return StringUtils.isEmpty(callback) ? result : (callback+"("+result+");");
	}

}

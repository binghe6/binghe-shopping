package com.binghe.shopping.manage.web.controller.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binghe.shopping.common.bean.resp.CommonResp;
import com.binghe.shopping.manage.service.IItemParamItemService;

@RestController
@RequestMapping("/item/param/item")
public class ItemParamItemController {

	@Autowired
	private IItemParamItemService itemParamItemService;
	
	/**
	 * 根据商品ID查询商品规格
	 * @param itemId
	 * @return
	 */
	@GetMapping("/item/get/{itemId}")
	public CommonResp getItemParamItemByItemId(@PathVariable("itemId") long itemId) {
		return itemParamItemService.getItemParamItemByItemId(itemId);
	}
}

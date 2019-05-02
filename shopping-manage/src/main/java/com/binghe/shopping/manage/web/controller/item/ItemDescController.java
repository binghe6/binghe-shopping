package com.binghe.shopping.manage.web.controller.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binghe.shopping.common.bean.resp.CommonResp;
import com.binghe.shopping.manage.service.IItemDescService;

@RestController
@RequestMapping("/item/desc")
public class ItemDescController {

	@Autowired
	private IItemDescService itemDescService;
	
	/**
	 * 查询商品描述
	 * @param itemId
	 * @return
	 */
	@GetMapping("/get/{itemId}")
	public CommonResp getItemDesc(@PathVariable("itemId") long itemId) {
		return itemDescService.getItemDescByItemId(itemId);
	}
}

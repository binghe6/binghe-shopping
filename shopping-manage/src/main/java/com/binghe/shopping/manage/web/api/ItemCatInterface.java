package com.binghe.shopping.manage.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binghe.shopping.manage.service.IItemCatService;

@RestController
@RequestMapping("/api/item/cat")
public class ItemCatInterface {

	@Autowired
	private IItemCatService itemCatService;
	
	/**
	 * 按首页需要的格式查询商品类目
	 * @param callback 回调的方法名
	 * @return
	 */
	@GetMapping("/all")
	public String listAllItemCat(@RequestParam("callback") String callback) {
		return itemCatService.listAllItemCat(callback);
	}
}

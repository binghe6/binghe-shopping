package com.binghe.shopping.manage.web.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binghe.shopping.common.bean.resp.CommonResp;
import com.binghe.shopping.manage.pojo.BaseItem;
import com.binghe.shopping.manage.service.IItemService;
import com.binghe.shopping.manage.web.BaseController;

@RestController
@RequestMapping("/item")
public class ItemController extends BaseController {

	@Autowired
	private IItemService itemService;
	
	@PostMapping("/add")
	public CommonResp addItem(BaseItem item, @RequestParam("desc")String itemDesc) {
		return itemService.addItem(item, itemDesc);
	}
}

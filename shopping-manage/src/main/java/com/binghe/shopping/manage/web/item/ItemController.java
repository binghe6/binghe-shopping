package com.binghe.shopping.manage.web.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binghe.shopping.common.bean.resp.CommonResp;
import com.binghe.shopping.common.bean.resp.EasyUIResp;
import com.binghe.shopping.manage.pojo.BaseItem;
import com.binghe.shopping.manage.service.IItemService;
import com.binghe.shopping.manage.web.BaseController;

@RestController
@RequestMapping("/item")
public class ItemController extends BaseController {

	@Autowired
	private IItemService itemService;
	
	/**
	 * 新增商品
	 * @param item
	 * @param itemDesc
	 * @return
	 */
	@PostMapping("/add")
	public CommonResp addItem(BaseItem item, @RequestParam("desc")String itemDesc) {
		return itemService.addItem(item, itemDesc);
	}
	/**
	 * 编辑商品
	 * @param item
	 * @param itemDesc
	 * @return
	 */
	@PostMapping("/edit")
	public CommonResp editItem(BaseItem item, @RequestParam("desc")String itemDesc) {
		return itemService.editItem(item, itemDesc);
	}
	
	/**
	 * 查询商品
	 * @param page 第几页
	 * @param rows 一页几条数据
	 * @return
	 */
	@GetMapping("/list")
	public EasyUIResp listItem(@RequestParam(value="page",defaultValue="1")int page, @RequestParam(value="rows",defaultValue="30")int rows) {
		return itemService.listItem(page, rows);
	}
	
	/**
	 * 查询商品描述
	 * @param itemId
	 * @return
	 */
	@GetMapping("/desc/get/{itemId}")
	public CommonResp getItemDesc(@PathVariable("itemId") long itemId) {
		return itemService.getItemDescByItemId(itemId);
	}
}

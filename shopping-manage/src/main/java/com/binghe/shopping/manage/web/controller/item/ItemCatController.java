package com.binghe.shopping.manage.web.controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binghe.shopping.common.bean.resp.CommonResp;
import com.binghe.shopping.manage.pojo.BaseItemCat;
import com.binghe.shopping.manage.service.IItemCatService;
import com.binghe.shopping.manage.web.controller.BaseController;

@RestController
@RequestMapping("/item/cat")
public class ItemCatController extends BaseController {

	@Autowired
	private IItemCatService itemCatService;
	
	/**
	 * 根据父商品类目ID获取其子类目列表
	 * @param parentId
	 * @return
	 */
	@GetMapping("/list")
	public List<BaseItemCat> listItemCatByParentId(@RequestParam(defaultValue="0", value="id")Long parentId) {
		return itemCatService.listItemCatByParentId(parentId);
	}
	
	/**
	 * 根据商品类目ID获取商品类目
	 * @param itemCatId
	 * @return
	 */
	@GetMapping("/get/{itemCatId}")
	public CommonResp getItemCatByItemCatId(@PathVariable("itemCatId") long itemCatId) {
		return itemCatService.getItemCatByItemCatId(itemCatId);
	}
}

package com.binghe.shopping.manage.web.controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binghe.shopping.common.bean.resp.CommonResp;
import com.binghe.shopping.common.bean.resp.EasyUIResp;
import com.binghe.shopping.manage.service.IItemParamService;

@RestController
@RequestMapping("/item/param")
public class ItemParamController {
	
	@Autowired
	private IItemParamService itemParamService;

	/**
	 * 查询商品规格
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/list")
	public EasyUIResp listItemParam(@RequestParam(value="page",defaultValue="1")int page, @RequestParam(value="rows",defaultValue="30")int rows) {
		return itemParamService.listItemParam(page, rows);
	}
	
	/**
	 * 根据商品类目ID查询商品规格
	 * @param itemCatId
	 * @return
	 */
	@GetMapping("/get/{itemCatId}")
	public CommonResp getItemParamByItemCatId(@PathVariable("itemCatId") long itemCatId) {
		return itemParamService.getItemParamByItemCatId(itemCatId);
	}
	
	/**
	 * 添加商品规格模版
	 * @param paramData
	 * @return
	 */
	@PostMapping("/add/{cid}")
	public CommonResp addItemParam(@RequestParam("paramData") String paramData, @PathVariable("cid") long cid) {
		return itemParamService.addItemParam(paramData, cid);
	}
	
	/**
	 * 删除商品规格模版
	 * @param ids
	 * @return
	 */
	@PostMapping("/delete")
	public CommonResp deleteItemParamByIds(@RequestParam("ids") List<Long> ids) {
		return itemParamService.deleteItemParamByIds(ids);
	}
}

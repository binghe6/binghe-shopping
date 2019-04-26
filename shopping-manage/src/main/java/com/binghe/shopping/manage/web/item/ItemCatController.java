package com.binghe.shopping.manage.web.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binghe.shopping.manage.pojo.BaseItemCat;
import com.binghe.shopping.manage.service.IItemCatService;
import com.binghe.shopping.manage.web.BaseController;

@RestController
@RequestMapping("/item/cat")
public class ItemCatController extends BaseController {

	@Autowired
	private IItemCatService itemCatService;
	
	@GetMapping("/list")
	public List<BaseItemCat> listItemCatByParentId(@RequestParam(defaultValue="0", value="id")Long parentId) {
		return itemCatService.listItemCatByParentId(parentId);
	}
}

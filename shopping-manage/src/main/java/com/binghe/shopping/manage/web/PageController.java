package com.binghe.shopping.manage.web;

import java.text.MessageFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

	@GetMapping("/{pageName}")
	public String toPage(@PathVariable("pageName")String pageName) {
		return pageName;
	}
	
	@GetMapping("/{pathName}/{pageName}")
	public String toSecondPage(@PathVariable("pathName")String pathName, @PathVariable("pageName")String pageName) {
		return MessageFormat.format("{0}/{1}", pathName, pageName);
	}
}

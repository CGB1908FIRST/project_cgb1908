package com.cy.res.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class PageController {
	/**返回首页页面*/
	@RequestMapping("doHomeUI")
	public String doHomeUI(Model model) {
		return "home";
	}
	@RequestMapping("shopBoard")
	public String shopBoard() {
		return "showBoard";
	}
	@RequestMapping("shopPage")
	public String shopPage() {
		return "shopInfo";
	}
	@RequestMapping("shopEdit")
	public String shopEdit() {
		return "shopEdit";
	}
	@RequestMapping("{moduleUI}")
	public String doModuleUI(@PathVariable String moduleUI) {
		return moduleUI;
	}
}

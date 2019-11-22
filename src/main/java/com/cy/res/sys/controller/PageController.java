package com.cy.res.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {

	/**返回首页页面*/
	@RequestMapping("doHomeUI")
	public String doHomeUI(Model model) {
		return "home";
	}
	
}

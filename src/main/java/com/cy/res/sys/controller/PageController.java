package com.cy.res.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys/")
public class PageController {
	
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
	
}

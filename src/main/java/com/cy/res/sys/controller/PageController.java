package com.cy.res.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.res.sys.entity.AreaEntity;
import com.cy.res.sys.entity.CategoryEntity;
import com.cy.res.sys.entity.ProductEntity;
import com.cy.res.sys.service.AreaService;
import com.cy.res.sys.service.CategoryService;
import com.cy.res.sys.service.ProductService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class PageController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private ProductService productService;
	/**返回首页页面*/
	@RequestMapping("doHomeUI")
	public String doHomeUI(Model model) {
		//查询所有商品分类信息并封装到model
		List<CategoryEntity> categoryList = categoryService.findAllCategory();
		model.addAttribute("categoryList", categoryList);
		//查询所有地区信息并封装到model
		List<AreaEntity> areaList = areaService.findAllArea();
		model.addAttribute("areaList", areaList);
		List<ProductEntity> productList = productService.findAllProduct("");
		model.addAttribute("productList", productList);
		return "home";
	}
	@RequestMapping("showShopInfo")
	public String shopBoard() {
		return "shopInfoPage";
	}
	@RequestMapping("starter")
	public String mystarter() {
		return "mystarter";
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

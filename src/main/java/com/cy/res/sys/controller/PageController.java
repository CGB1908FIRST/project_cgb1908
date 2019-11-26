package com.cy.res.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.res.sys.entity.AreaEntity;
import com.cy.res.sys.entity.CategoryEntity;
import com.cy.res.sys.service.AreaService;
import com.cy.res.sys.service.CategoryService;


@Controller
@RequestMapping("/")
public class PageController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private AreaService areaService;
	/**返回首页页面*/
	@RequestMapping("doHomeUI")
	public String doHomeUI() {
		return "home";
	}
	@RequestMapping("doSelectUI")
	public String doHomeUI(Model model) {
		//查询所有商品分类信息并封装到model
		List<CategoryEntity> categoryList = categoryService.findAllCategory();
		model.addAttribute("categoryList", categoryList);
		//查询所有地区信息并封装到model
		List<AreaEntity> areaList = areaService.findAllArea();
		model.addAttribute("areaList", areaList);
		return "selectOption";
	}
	@RequestMapping("showShopInfo")
	public String shopBoard() {
		return "shopInfoPage";
	}
	@RequestMapping("starter")
	public String mystarter() {
		return "mystarter";
	}
	@RequestMapping("{moduleUI}")
	public String doModuleUI(@PathVariable String moduleUI) {
		System.out.println(moduleUI);
		return moduleUI;
	}
	@RequestMapping("releaseProductPage")
	public String releaseProductPage(Model model) {
		List<CategoryEntity> categoryList = categoryService.findAllCategory();
		model.addAttribute("categoryList",categoryList);
		return "releaseProductPage";
	}
	@RequestMapping("doInsert")
	public String doInsert() {
		return "doInsert";
	}
	@RequestMapping("doFindComments")
	public String doFindCommentByProductId(Integer productId) {
		return "doFindComments"; //
	}
	@RequestMapping("demo")
	public String dome() {
		return "demo"; //
	}
	
}

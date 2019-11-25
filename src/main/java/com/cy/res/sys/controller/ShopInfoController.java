package com.cy.res.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.res.sys.entity.FindProductEntity;
import com.cy.res.sys.entity.ProductEntity;
import com.cy.res.sys.entity.ShopInfo;
import com.cy.res.sys.service.ProductService;
import com.cy.res.sys.service.ShopInfoService;
import com.cy.res.sys.vo.JsonResult;

@Controller

public class ShopInfoController {
	@Autowired
	ShopInfoService shopInfoService;
	@Autowired
	ProductService productService;
	
	@RequestMapping("doFindAllProduct")
	public String doFindAllProduct(Model model) {
		List<ShopInfo> shopList = shopInfoService.findAllShop();
		model.addAttribute("shopList",shopList);    
		return "allshop";
	}
	@RequestMapping("findShopInfoString")
	public String findShopInfoString(Integer memberId,Model model) {
		List<ShopInfo> shopData = shopInfoService.findShopInfoByMemberId(memberId);
		List<ProductEntity> productList = productService.findProductByMemberId(memberId);
		model.addAttribute("shopData",shopData);  
		model.addAttribute("productList",productList);  
		return "shopcart";
	}
	@RequestMapping("findShopInfo")
	@ResponseBody
	public JsonResult findShopInfo(Integer memberId) {
		List<ShopInfo> data = shopInfoService.findShopInfoByMemberId(memberId);
		return new JsonResult(data);
	}
	@RequestMapping("updateShopInfo")
	@ResponseBody
	public JsonResult updateShopInfo(ShopInfo shopInfo) {
		
		shopInfoService.updateShopInfo(shopInfo);
		return new JsonResult("update ok");
	}
	@RequestMapping("DoFindAllShopInfo")
	@ResponseBody
	public JsonResult DoFindAllShopInfo(ShopInfo shopInfo) {
		List<ShopInfo> shopList = shopInfoService.findAllShop();
		return new JsonResult(shopList);
	}
	
}

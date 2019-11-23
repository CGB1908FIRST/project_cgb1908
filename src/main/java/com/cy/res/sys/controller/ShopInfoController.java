package com.cy.res.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.res.sys.entity.ShopInfo;
import com.cy.res.sys.service.ShopInfoService;
import com.cy.res.sys.vo.JsonResult;

@Controller
@ResponseBody
public class ShopInfoController {
	@Autowired
	ShopInfoService shopInfoService;
	
	@RequestMapping("findShopInfo")
	public JsonResult findShopInfo(Integer memberId) {
		List<ShopInfo> data = shopInfoService.findShopInfoByMemberId(memberId);
		return new JsonResult(data);
	}
	@RequestMapping("updateShopInfo")
	public JsonResult updateShopInfo(ShopInfo shopInfo) {
		
		shopInfoService.updateShopInfo(shopInfo);
		return new JsonResult("update ok");
	}
	@RequestMapping("DoFindAllShopInfo")
	public JsonResult DoFindAllShopInfo(ShopInfo shopInfo) {
		List<ShopInfo> shopList = shopInfoService.findAllShop();
		return new JsonResult(shopList);
	}
}

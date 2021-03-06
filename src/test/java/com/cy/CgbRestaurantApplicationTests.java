package com.cy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.res.common.vo.JsonResult;
import com.cy.res.sys.controller.CategoryController;
import com.cy.res.sys.controller.ProductController;
import com.cy.res.sys.dao.HxdUserDao;
import com.cy.res.sys.dao.ShopDao;
import com.cy.res.sys.entity.HxdUser;
import com.cy.res.sys.entity.ShopInfo;
import com.cy.res.sys.service.HxdUserService;


@SpringBootTest
class CgbRestaurantApplicationTests {
	@Autowired
	private HxdUserService hxdUserServcie;
	@Autowired
	private HxdUserDao hxdUserDao;
	@Autowired
	private CategoryController categoryController;
	@Autowired
	private ProductController productController;
	@Autowired
	ShopDao shopDap;

	@Test
	public void testCategoryController() {
		JsonResult doFindAllCategory = categoryController.doFindAllCategory();
		System.out.println(doFindAllCategory.toString());
	}
	@Test
//	public void testProductController() {
//		JsonResult doFindAllProduct = productController.doFindAllProduct("productCurrentPrize");
//		System.out.println(doFindAllProduct.getData().toString());
//	}
	void contextLoads() {
		ShopInfo shopInfo = new ShopInfo();
		shopInfo.setMemberId(3);
		int row = shopDap.updateShopInfo(shopInfo);
		System.out.println(row);
	}
}

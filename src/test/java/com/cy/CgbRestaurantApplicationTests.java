package com.cy;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.res.common.vo.JsonResult;
import com.cy.res.sys.controller.CategoryController;
import com.cy.res.sys.controller.ProductController;

@SpringBootTest
class CgbRestaurantApplicationTests {

	@Autowired
	private CategoryController categoryController;
	@Autowired
	private ProductController productController;
	@Test
	public void testCategoryController() {
		JsonResult doFindAllCategory = categoryController.doFindAllCategory();
		System.out.println(doFindAllCategory.toString());
	}
	@Test
	public void testProductController() {
		JsonResult doFindAllProduct = productController.doFindAllProduct("productCurrentPrize");
		System.out.println(doFindAllProduct.getData().toString());
	}

}

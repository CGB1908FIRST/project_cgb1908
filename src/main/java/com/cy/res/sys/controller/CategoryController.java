package com.cy.res.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.res.common.vo.JsonResult;
import com.cy.res.sys.entity.CategoryEntity;
import com.cy.res.sys.service.CategoryService;

@RestController
@RequestMapping("/category/")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	@RequestMapping("doFindAllCategory")
	public JsonResult doFindAllCategory() {
		List<CategoryEntity> categoryList = categoryService.findAllCategory();
		return new JsonResult(categoryList);
	}
}

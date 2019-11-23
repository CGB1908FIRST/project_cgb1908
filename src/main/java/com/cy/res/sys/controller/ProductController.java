package com.cy.res.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.res.common.vo.JsonResult;
import com.cy.res.sys.entity.ProductEntity;
import com.cy.res.sys.service.ProductService;

/**
 * product控制层对象用于接收和响应页面和product相关的请求
 * @author xukeqing
 *
 */
@Controller
@ResponseBody
@RequestMapping("/product/")
public class ProductController {

	@Autowired
	private ProductService productService;
	@RequestMapping("doFindAllProduct")
	public JsonResult doFindAllProduct(String colnum) {
		List<ProductEntity> productList = productService.findAllProduct(colnum);
		return new JsonResult(productList);
	}

}

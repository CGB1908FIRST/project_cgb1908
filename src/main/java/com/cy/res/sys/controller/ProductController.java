package com.cy.res.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cy.res.common.vo.JsonResult;
import com.cy.res.sys.entity.CommentEntity;
import com.cy.res.common.vo.PageObject;
import com.cy.res.sys.entity.FindProductEntity;
import com.cy.res.sys.entity.ProductEntity;
import com.cy.res.sys.entity.ShopInfo;
import com.cy.res.sys.service.CommentService;
import com.cy.res.sys.service.ProductService;
import com.cy.res.sys.service.ShopInfoService;

/**
 * product控制层对象用于接收和响应页面和product相关的请求
 * 
 * @author xukeqing
 *
 */
@Controller
@RequestMapping("/product/")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private ShopInfoService ShopInfoService;
	
	@RequestMapping("gotoDetail")
	public String gotoDetail(Integer productId,Model model) {
		ProductEntity product = productService.findProductById(productId);
		List<CommentEntity> commentList = commentService.findCommentByProductId(productId);
		int memberId = product.getMemberId();
		List<ShopInfo> shop = ShopInfoService.findShopInfoByMemberId(memberId);
		model.addAttribute("product", product);
		model.addAttribute("commentList", commentList);
		model.addAttribute("shop", shop.get(0));
		return "productdetail";
	}
	@RequestMapping("doFindAllProduct")
	public String doFindAllProduct(FindProductEntity findProductEntity,Model model) {
		List<ProductEntity> productList = productService.findAllProduct(findProductEntity);
		model.addAttribute("productList",productList);    
		return "allproduct";
	}
	/**
	 * 
	 * @param 通过商品id删除
	 * @return liuhaibo
	 */
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		productService.doDeleteObject(id);
		return new JsonResult("delete ok");
	}
	
	
	/**
	 * 新增商品
	 */
	@RequestMapping("doReleaseProcduct")
	@ResponseBody
	public JsonResult doreleaseProcduct(ProductEntity entity) {
		System.out.println(entity);
		productService.productInsert(entity);
		return new JsonResult("update ok");
	}
	
	/**
	 * 分页查询
	 */
	@RequestMapping("doFindPageObject")
	@ResponseBody
	public JsonResult dofindPageObject(Integer memberId, Integer pageCurrent) {
		PageObject<ProductEntity> data = productService.findPageObject(memberId, pageCurrent);
		
		return new JsonResult(data);
	}
	/**
	 * 根据商品id查询商品信息
	 */
	@RequestMapping("findProductByProductId")
	@ResponseBody
	public JsonResult doFindProductByProductId(Integer productId) {
		ProductEntity data = productService.findProductById(productId);
		return new JsonResult(data);
	}
	
	@RequestMapping("updateProduct")
	@ResponseBody
	public JsonResult doUpdateProduct(ProductEntity entity) {
		productService.updateProduct(entity);
		return new JsonResult("update ok");
	}
}

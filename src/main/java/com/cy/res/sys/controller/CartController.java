package com.cy.res.sys.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.res.commom.vo.ServiceException;
import com.cy.res.common.vo.Cart;
import com.cy.res.common.vo.CartItem;
import com.cy.res.sys.entity.ProductEntity;
import com.cy.res.sys.service.ProductService;


@Controller
public class CartController {
	
	@Autowired
	private ProductService productService;
	
	//加入购物车
	@RequestMapping(value="/shopping/buyerCart")
	public String buyerCart(Integer productId, Integer amount, Model model,HttpServletRequest request){
		Cart buyerCart = null;
		//1,获取Session中的购物车
		HttpSession session = request.getSession();
		Object cart = session.getAttribute("cart");
		if(null != cart) {
			buyerCart = (Cart)cart;
		}else {
			//2,Session中没有购物车, 创建购物车对象
			buyerCart = new Cart();
		}
		//3, 将当前款商品追加到购物车
		if(null != productId && null != amount) {
			ProductEntity product = productService.findProductById(productId);
			CartItem buyerItem = new CartItem();
			buyerItem.setProduct(product);
			//设置数量
			buyerItem.setBuyNum(amount);
			//添加购物项到购物车
			buyerCart.addItem(buyerItem);
			buyerItem.setSubTotal(buyerItem.getBuyNum()*product.getProductCurrentPrize());
		}
		//排序  倒序
		List<CartItem> items = buyerCart.getCartItems();
		Collections.sort(items, new Comparator<CartItem>() {
			@Override
			public int compare(CartItem o1, CartItem o2) {
				return -1;
			}
		});
		//4, 保存购物车到Session中
		session.setAttribute("cart", buyerCart);
		model.addAttribute("cart", buyerCart);
		//6, 返回
		return "cart";
	}
	//删除购物车中的内容
	@RequestMapping(value="/shopping/deleteCart")
	public String deleteCart(HttpServletRequest request) {
		//1,获取Session中的购物车
		HttpSession session = request.getSession();
		Object cart = session.getAttribute("cart");
		if(null != cart) {
			session.removeAttribute("cart");
		}
		return "shopcart";
	}
	//支付
	@RequestMapping(value="/shopping/toPay")
	public String toPay(Model model,HttpServletRequest request) {
		Cart buyerCart = null;
		//1,获取Session中的购物车
		HttpSession session = request.getSession();
		Object cart = session.getAttribute("cart");
		if(null == cart) {
			throw new ServiceException("您没还没有选择商品");
		}else {
			buyerCart = (Cart)cart;
		}
		model.addAttribute("buyerCart", buyerCart);
		return "pay";
	}
}

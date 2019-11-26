package com.cy.res.sys.service.impl;

import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cy.res.commom.vo.ServiceException;
import com.cy.res.common.vo.Cart;
import com.cy.res.common.vo.CartItem;
import com.cy.res.sys.entity.SysOrder;
import com.cy.res.sys.service.SysOrderService;
@Service
public class SysOrderServiceImpl implements SysOrderService{
	@Autowired
	private com.cy.res.sys.dao.SysOrderDao SysOrderDao;
	@Override
	public SysOrder selectObjectByUserId(Integer id) {
		//效验参数
		if(id==null)
			throw new ServiceException("id不能为空");
		SysOrder orderData = SysOrderDao.selectObjectByUserId(id);
		return orderData;
	}
	@Override
	public void paySuccessInsert(HttpServletRequest request) {
		Cart cart = null;
		HttpSession session = request.getSession();
		Object object = session.getAttribute("cart");
		if(object == null) {
			throw new ServiceException("没有商品");
		}
		cart = (Cart)object;
		SysOrder order = new SysOrder();
		String orderNum = UUID.randomUUID().toString();
		List<CartItem> cartItems = cart.getCartItems();
		for (CartItem cartItem : cartItems) {
			order.setOrderNum(orderNum);
			order.setOrderPrice(cart.getPrice());
			order.setOrderIsComment("N");
			order.setProductId(cartItem.getProduct().getProductId());
			order.setProductName(cartItem.getProduct().getProductName());
			order.setProductPrice(cartItem.getSubTotal());
			order.setProductCount(cartItem.getBuyNum());
			order.setMemberId(cartItem.getProduct().getMemberId());
			order.setUserId(1);
			int rows = SysOrderDao.paySuccessInsert(order);
			if(rows==0) {
				throw new ServiceException("订单生成失败");
			}
		}
	}
}

package com.cy.res.common.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * 购物车实体类
 * @author Administrator
 *
 */
@Data
public class Cart implements Serializable{
	private static final long serialVersionUID = 2037970208787323769L;

	private List<CartItem> cartItems=new ArrayList<CartItem>();
	private int amount;
	private float price; 
	//添加购物项到购物车
	public void addItem(CartItem item){
		//判断是否包含同款
		if(cartItems.contains(item)) {
			//追加数量
			for(CartItem buyerItem : cartItems) {
				if(buyerItem.equals(item)) {
					buyerItem.setBuyNum(item.getBuyNum() + buyerItem.getBuyNum());
				}
			}
		}else{
			cartItems.add(item);
		}
		amount = getProductAmount();
		price = getProductPrice();
	}
	@JsonIgnore
	public Integer getProductAmount(){
		Integer result = 0;
		//计算
		for (CartItem buyerItem : cartItems) {
			result += buyerItem.getBuyNum();
		}
		return result;
	}
	//商品金额
	@JsonIgnore
	public Float getProductPrice(){
		Float result = 0f;
		//计算
		for(CartItem buyerItem : cartItems) {
			result+=buyerItem.getBuyNum()*buyerItem.getProduct().getProductCurrentPrize();
		}
		return result;
	}
}

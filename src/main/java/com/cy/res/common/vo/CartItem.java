package com.cy.res.common.vo;

import java.io.Serializable;

import com.cy.res.sys.entity.ProductEntity;

import lombok.Data;
/**
 * 用于封装购物车中的项目的信息
 * @author xukeqing
 *
 */
@Data
public class CartItem implements Serializable{
	private static final long serialVersionUID = 1L;
	private ProductEntity product;//商品
	private int buyNum;//个数
	private double subTotal;//小计

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) //比较地址
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.getProductId().equals(other.product.getProductId()))
			return false;
		return true;
	}
}

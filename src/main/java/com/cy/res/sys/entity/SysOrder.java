package com.cy.res.sys.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class SysOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5327516804907579340L;
	/**自增ID*/
	private Integer id;
	/**订单号*/
	private String orderNum;
	/**订单价格*/
	private Float orderPrice;
	/**订单评论*/
	private String orderIsComment;
	/**订单日期*/
	private Date orderDate;
	/**商品ID*/
	private Integer productId;
	/**商品名称*/
	private String productName;
	/**产品价格*/
	private Double productPrice;
	/**产品数量*/
	private Integer productCount;
	/**会员ID*/
	private Integer memberId;
	/**用户ID*/
	private Integer userId;
	/**生产日期*/
	private Date createdTime;
	/**修改日期*/
	private Date modifiedTime;
	/**创建用户*/
	private String createdUser;
	/**修改用户*/
	private String modifiedUser;

}

package com.cy.res.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * product实体类用于封装product数据
 * @author xukeqing
 *
 */
@Data
public class ProductEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	/*product id*/
	private Integer productId;
	/*product 名字*/
	private String productName;
	/*product 副标题*/
	private String productSubtitle;
	/*product 原价*/
	private Float productOriginalPrize;
	/*product 销售量*/
	private Integer productSellNum;
	/*product 评分*/
	private Float productCore;
	/*product 现价*/
	private Float productCurrentPrize;
	/*product 图片链接*/
	private String productImgUrl;
	/*product 外键关联的商品分类id*/
	private Integer categoryId;
	/*product 外键关联的商家id*/
	private Integer memberId;
	/*product 创建时间*/
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;
	
}

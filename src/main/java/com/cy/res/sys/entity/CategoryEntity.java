package com.cy.res.sys.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 商品分类的实体类
 * @author Administrator
 *
 */
@Data
public class CategoryEntity implements Serializable{
	private static final long serialVersionUID = -1548164848927699449L;
	/*商品分类的id*/
	private Integer categoryId;
	/*商品分类的分类名*/
	private String categoryName;
	/*创建时间*/
	private String createdTime;
	/*修改时间*/
	private String modifiedTime;
	/*创建用户*/
	private String createdUser;
	/*修改用户*/
	private String modifiedUser;

}

package com.cy.res.sys.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 地区的实体类
 * @author Administrator
 *
 */
@Data
public class AreaEntity implements Serializable{
	private static final long serialVersionUID = -4102938109094625456L;

	/*地区id*/
	private Integer areaId;
	/*地区名字*/
	private String areaName;
	/*创建时间*/
	private String createdTime;
	/*修改时间*/
	private String modifiedTime;
	/*创建用户*/
	private String createdUser;
	/*修改用户*/
	private String modifiedUser;
}

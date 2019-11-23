package com.cy.res.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class ShopInfo implements Serializable {
	private static final long serialVersionUID = 8457487852731970018L;
	//商店名称
	private String shopName;
	//商店地址
	private String shopAddress;
	//商店公告
	private String shopMessage;
	//负责人
	private String memberName;
	//负责人电话
	private String memberPhone;
	//商家图片地址
	private String shopImgUrl;
	
	private Integer memberId;
	private String memberPassword;
	private Integer areaId;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;
	
	
}

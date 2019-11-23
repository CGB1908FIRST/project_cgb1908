package com.cy.res.sys.entity;

import java.util.Date;

import lombok.Data;
@Data
public class HxdUser {
	private Integer userId;
	private String userLoginName;
	private String userNickName;
	private String userTrueName;
	private String userPassword;
	private String userPhone;
	private String userAddress;
	private Date userCreateTime;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;
	private String salt;
}

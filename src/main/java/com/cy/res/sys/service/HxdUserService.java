package com.cy.res.sys.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.cy.res.sys.entity.HxdUser;


public interface HxdUserService {
	
	int insertObject(HxdUser userData,HttpServletRequest request);
	
	int isLogin(String username,String password,Boolean isRememberMe);
	
	int findUserByUsername(String username);
//	List<HxdUser> findOnebyLoginName(String LoginName);
}

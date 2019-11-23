package com.cy.res.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cy.res.sys.entity.HxdUser;


public interface HxdUserService {
	
	int insertObject(HxdUser userData);
	
	int isLogin(String username,String password);
//	List<HxdUser> findOnebyLoginName(String LoginName);
}

package com.cy.res.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.res.sys.entity.HxdUser;
import com.cy.res.sys.service.HxdUserService;
import com.cy.res.sys.vo.JsonResult;

@RestController
@RequestMapping("/user/")
public class HxdUserController {
	@Autowired
	private HxdUserService hxdUserService;
	@RequestMapping("regist")
	public JsonResult regist(HxdUser userData) {
		hxdUserService.insertObject(userData);
		return new JsonResult("恭喜,注册成功");
	}
	@RequestMapping("dologin")
	public JsonResult doLogin(String username,String password,Boolean isRemenberMe) {
		hxdUserService.isLogin(username, password,isRemenberMe);
		System.out.println("HxdUserController.doLogin()");
		return new JsonResult("登陆成功!");
	}
}

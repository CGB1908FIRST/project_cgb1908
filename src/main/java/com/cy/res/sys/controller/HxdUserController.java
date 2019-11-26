package com.cy.res.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
	public JsonResult regist(HxdUser userData,HttpServletRequest request) {
		hxdUserService.insertObject(userData,request);
		return new JsonResult("恭喜,注册成功");
	}

//	@RequestMapping("dologin")
//	public JsonResult doLogin(String username,String password,Boolean isRememberMe) {
//		//hxdUserService.isLogin(username, password,isRemenberMe);
//		
//		//1.封装用户信息
//		 UsernamePasswordToken token=new UsernamePasswordToken(username, password);
//		 if(isRememberMe) {
//			token.setRememberMe(true); 
//		 }
//		 //2.提交用户信息
//		 Subject subject=SecurityUtils.getSubject();
//		 subject.login(token);//token会提交给securityManager
//		return new JsonResult("登陆成功!");
//	}
	@RequestMapping("dologin")
	public JsonResult doLogin(String username, String password, boolean isRememberMe) {
		hxdUserService.isLogin(username, password,isRememberMe);
//		Subject subject = SecurityUtils.getSubject();
//		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//		if (isRememberMe)
//			token.setRememberMe(true);
//		subject.login(token);// 提交给securityManager
		return new JsonResult("login ok");
	}
	@RequestMapping("userIsExist")
	public JsonResult userIsExist(String username) {
		hxdUserService.findUserByUsername(username);
		return new JsonResult("1");
	}
	@RequestMapping("rePassword")
	public JsonResult repassword(String password,String repassword,Integer id) {
		hxdUserService.updataPsswordById(password, repassword, id);
		return new JsonResult("repassword ok");
	}
}

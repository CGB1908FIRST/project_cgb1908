package com.cy;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.res.sys.dao.HxdUserDao;
import com.cy.res.sys.entity.HxdUser;
import com.cy.res.sys.service.HxdUserService;

@SpringBootTest
class CgbRestaurantApplicationTests {

	@Autowired
	private HxdUserService hxdUserServcie;
	@Autowired
	private HxdUserDao hxdUserDao;
	@Test
	void contextLoads() {
	}
	@Test
	public void testUserInsert() {
		HxdUser hxdUser = new HxdUser();
		hxdUser.setUserPassword("123456");
		hxdUser.setUserLoginName("123");
		Integer row = hxdUserServcie.insertObject(hxdUser);
		System.out.println(row);
	}
	@Test
	public void testFindUsername() {
		HxdUser LoginName = hxdUserDao.findOnebyLoginName("zzh");
		System.out.println(LoginName);
	}
	@Test
	public void testIsLogin() {
		String username = "zzh";
		String password = "123456";
		int row = hxdUserServcie.isLogin(username, password);
		System.out.println(row);
	}
}

package com.cy;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.res.sys.dao.ShopDao;
import com.cy.res.sys.entity.ShopInfo;

@SpringBootTest
class CgbRestaurantApplicationTests {
	@Autowired
	ShopDao shopDap;
	@Test
	void contextLoads() {
		ShopInfo shopInfo = new ShopInfo();
		shopInfo.setMemberId(3);

		int row = shopDap.updateShopInfo(shopInfo);
		System.out.println(row);
	}

}

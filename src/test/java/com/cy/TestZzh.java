package com.cy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.res.sys.controller.UtilController;

@SpringBootTest
class TestZzh {
	@Autowired
	private UtilController utilController;
	@Test
	public void test01() {
		String mobile = "";
//		utilController.dosend(mobile, request);
	}
}

package com.cy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.res.sys.service.impl.realm.HxdUserNoteMsg;

@SpringBootTest
class TestZzh {
	@Autowired
	private HxdUserNoteMsg hxdUserNoteMsg;
	@Test
	public void test01() {
		String mobile = "13027990019";
		try {
			hxdUserNoteMsg.SendMsg(mobile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("出错了");
		}
	}
}

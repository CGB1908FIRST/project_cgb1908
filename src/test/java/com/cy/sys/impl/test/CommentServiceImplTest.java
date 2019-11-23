package com.cy.sys.impl.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.res.sys.service.CommentService;



/**该类用于测试CommentServiceImpl中的方法
 * @author xiezhonghuai
 */
@SpringBootTest
public class CommentServiceImplTest {
	
	@Autowired
	private CommentService commentService;
	
	@Test
	public void insertTest() throws Exception {
		String commentContent="这是我的第二次好评！！！！";//不能为空字符串
		Double commentCore=4.1;//0~5
		Integer productId=12;
		Integer userId=2;
		
		int row = commentService.insert(commentContent, commentCore, productId, userId);
		
		if(row==1) {
			System.out.println("====> commentService.insert() is ok!!!");
		}else {
			System.out.println("====> commentService.insert is fail!!!");
		}
	}
	
}

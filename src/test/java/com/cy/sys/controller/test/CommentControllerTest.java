package com.cy.sys.controller.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.res.sys.controller.CommentController;



/**这个测试类用来测试CommentControllerTest里面的方法
 * @author xiezhonghuia
 *
 */
@SpringBootTest
public class CommentControllerTest {
	
	@Autowired
	private CommentController commentController;
	
	@Test
	public void doInsertTest() throws Exception {
		String commentContent="人家的评论像是山洪一样凶猛捏！嘻嘻@__@";
		Double commentCore=4.5;
		Integer productId=5;
		commentController.doInsert(commentContent, commentCore, productId);
	}
}

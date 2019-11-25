package com.cy.sys.controller.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.res.sys.controller.CommentController;
import com.cy.res.sys.entity.CommentEntity;



/**这个测试类用来测试CommentController里面的方法
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
	
	
	
	@Test
	public void doFindCommentByProductIdTest() {
		Integer productId=2;
		commentController.doFindCommentByProductId(productId);	
	}
	
	
	@Test
	public void doDeleteCommentTest(){
		CommentEntity comment =new CommentEntity();
		comment.setUserId(2);
		comment.setCommentId(27);
		commentController.doDeleteComment(comment);
	}
	
	
	
}

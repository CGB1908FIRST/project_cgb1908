package com.cy.sys.impl.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.res.commom.vo.ServiceException;
import com.cy.res.sys.entity.CommentEntity;
import com.cy.res.sys.service.CommentService;



/**该类用于测试CommentServiceImpl中的方法
 * @author xiezhonghuai
 */
@SpringBootTest
public class CommentServiceImplTest {
	
	@Autowired
	private CommentService commentService;
	

	/**测试insert()方法的测试用例方法
	 * @author xiezhonghuai
	 */
	@Test
	public void insertTest() throws ServiceException {
		String commentContent="这是我的第二次好评！！！！";//不能为空字符串
		Double commentCore=3.6;//0~5
		Integer productId=12;
		Integer userId=2;
		
		int row = commentService.insert(commentContent, commentCore, productId, userId);
		
		if(row==1) {
			System.out.println("====> commentService.insert() is ok!!!");
		}else {
			System.out.println("====> commentService.insert is fail!!!");
		}
	}
	
	@Test
	public void findCommentByProductIdTest() throws ServiceException {
		//Integer productId =null; //测试productId参数不正确
		//Integer productId =1000; //测试查询productId商品存在
		//Integer productId =12; //测试查询productId没有评价
		Integer productId =2; //测试查询productId正常返回一组评价
		List<CommentEntity> listCommentEntity = commentService.findCommentByProductId(productId);
		
		for(CommentEntity comment:listCommentEntity) {
			System.out.println("comment:"+comment);
		}
	}
	
	
	@Test
	public void deleteCommentTest() {
		Integer userId=2;
		CommentEntity comment =new CommentEntity();
		comment.setUserId(2);
		comment.setCommentId(27);
		
		int row = commentService.deleteComment(userId, comment);
		
		System.out.println("row"+row);
		if(row==1) 
			System.out.println("===============>>>   删除成功！");
	}
		
	
	
}


















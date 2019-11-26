package com.cy.sys.dao.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.res.sys.dao.CommentDao;
import com.cy.res.sys.entity.CommentEntity;

/**这个测试类用来测试CommentDao里面的方法
 * @author xiezhonghuia
 *
 */
@SpringBootTest
public class CommentDaoTest {
	
	@Autowired
	private CommentDao commentDao;
	
	
	/**测试insert()方法的测试用例方法
	 * @author xiezhonghuai
	 */
	@Test
	public void insertTest() {
		CommentEntity comment=new CommentEntity();
		comment.setCommentContent("吃了很多次，得力推荐。");
		comment.setCommentCore(3.6);
//CommentEntity.CommentCore若为Float会报错，小数默认为double,需要强转。
		
		comment.setProductId(6);
		comment.setUserId(2);
		
		int row = commentDao.insert(comment);
		if(row==1) {
			System.out.println("====> commentDao.insert() is ok!!!");
		}else {
			System.out.println("====> commentDao.insert() is fail!!!");
		}
	}
	
	/**测试findCommentByProductId()方法的测试用例方法
	 * @author xiezhonghuai
	 */
	@Test
	public void findCommentByProductIdTest() {
		//Integer productId=2;
		Integer productId=200;
		//Integer productId=2;
		
		List<CommentEntity> list = commentDao.findCommentByProductId(productId);
		for(CommentEntity comment:list) {
			System.out.println("comment:"+comment);
		}
	}
	
	/**测试deleteById()方法的测试用例方法
	 * @author xiezhonghuai
	 */
	@Test
	public void deleteByIdTest() {
		Integer commentId=20;
		int row = commentDao.deleteById(commentId);
		System.out.println("row"+row);
	}
	
	/**测试findCommentByCommentId()方法的测试用例方法
	 * @author xiezhonghuai
	 */

}

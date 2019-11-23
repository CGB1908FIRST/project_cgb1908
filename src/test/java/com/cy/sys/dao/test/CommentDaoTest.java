package com.cy.sys.dao.test;

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

}

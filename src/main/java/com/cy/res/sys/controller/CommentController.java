package com.cy.res.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.res.sys.entity.CommentEntity;
import com.cy.res.sys.service.CommentService;
import com.cy.res.sys.vo.JsonResult;



/**这是一个comment评论控制层，
 * 用于处理请求，调用业务层方法
 * @author xiezhonghuai
 */
@RequestMapping("/comment/")
@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	/**这是一个处理用户提交添加评论的方法，
	 * @author xiezhonghuai
	 */
	@RequestMapping("doInsert")
	public JsonResult doInsert(String commentContent,Double commentCore,Integer productId) throws Exception {
		//从session中获取用户id userId
		Integer userId =3;
		 productId =6;
		commentService.insert(commentContent, commentCore, productId, userId);
		
		return new JsonResult("恭喜！成功添加评论！");
		
		//url:locahost:8080/comment/doInsert
	}
	
	/**这是一个处理用户根据商品id查看商品评论的方法，
	 * @author xiezhonghuai
	 */
	@RequestMapping("doFindComments")
	public JsonResult doFindCommentByProductId(Integer productId) {
		//从页面中中获取商品id productId
				 productId =3;
		List<CommentEntity> lsitComment = commentService.findCommentByProductId(productId);
		return new JsonResult(lsitComment);
		//http://localhost/comment/doFindComments?productId=5
	}
	

	public JsonResult doDeleteComment(CommentEntity comment) {
		//从sesion中获取用户id
		Integer userId=6;
		commentService.deleteComment(userId, comment);
		return new JsonResult("恭喜！成功删除！");
	}
}

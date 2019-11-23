package com.cy.res.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}

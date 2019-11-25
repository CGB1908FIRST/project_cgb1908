package com.cy.res.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cy.res.commom.vo.ServiceException;
import com.cy.res.sys.entity.CommentEntity;

/**
 * Comment的业务层接口
 * @author xiezhonghuai
 *
 */
@Service
public interface CommentService {
	
	
	/**
	 * 用户基于用户ID和商品ID对商品添加评价的方法
	 * @author xiezhonghuai
	 *@param commentContent 评价文本内容
	 *@param commentCore 评价分数
	 *@param productId 商品id
	 *@param userId 用户id
	 *@return int 返回执行影响结果
	 * @throws Exception 
	 */
	public int insert(String commentContent,Double  commentCore,
			Integer productId,Integer userId) throws ServiceException;
	
	/**用户根据商品id查询商品评价,返回值为一组评论
	 * @author xiezhonghuai
	 *@param  Integer ProductId 商品id
	 *@return List<CommentEntity>  返回一个评价集合
	 * @throws Exception 
	 */
	public List<CommentEntity> findCommentByProductId(Integer productId) throws ServiceException;

	


	/**用户根据用户id，以及评论commentId删除评论
	 * @author xiezhonghuai
	 *@param  Integer userId 用户id
	 *@param CommentEntity comment 页面对象
	 */
	public int deleteComment(Integer userId,CommentEntity comment);

	
	
}

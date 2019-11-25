package com.cy.res.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cy.res.sys.entity.CommentEntity;

/**
 * Comment的业务层接口
 * @author xiezhonghuai
 *
 */
@Service
public interface CommentService {
	
	public List<CommentEntity> findCommentByProductId(Integer productId);
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
			Integer productId,Integer userId) throws Exception;
}

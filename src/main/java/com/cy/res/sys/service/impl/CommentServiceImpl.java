package com.cy.res.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.res.sys.dao.CommentDao;
import com.cy.res.sys.entity.CommentEntity;
import com.cy.res.sys.service.CommentService;

import io.micrometer.core.instrument.util.StringUtils;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
   private CommentDao commentDao;
	
	
	@Override
	public int insert(String commentContent,Double  commentCore,
			Integer productId,Integer userId) throws Exception{
		//1,参数有效性验证
		
		//1.1验证commentContent
		if(StringUtils.isEmpty(commentContent)) {
			throw new Exception("评价内容不能为空，请输入您的评语");
		}
		//1.2验证commentCore
		if(commentCore<=0 || commentCore>=5) {
			throw new Exception("评分超出0~5的范围，请输入正确评分数");
		}
		//1.3验证productId 
		//通过商品id查询商品信息，验证参数有效性
		
		//1.4验证userId
		//通过用户id查询用户信息，验证参数有效性
	
		//2初始化评价信息
		CommentEntity comment=new CommentEntity();
		comment.setCommentContent(commentContent);
		comment.setCommentCore(commentCore);
		comment.setProductId(productId);
		comment.setUserId(userId);
		int row = commentDao.insert(comment);
		
		//3验证结果
		if(row!=1) {
			throw new Exception("添加评论失败！");
		}
		return row;
	}


	@Override
	public List<CommentEntity> findCommentByProductId(Integer productId) {
		
		return commentDao.findCommentByProductId(productId);
	}

}

package com.cy.res.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cy.res.sys.entity.CommentEntity;

/**
 * 商品评价层接口
 * @author xiezhonghuai
 *
 */

@Mapper
public interface CommentDao {

	public int insert(CommentEntity comment);
	
	public List<CommentEntity> findCommentByProductId(Integer productId);
	
}

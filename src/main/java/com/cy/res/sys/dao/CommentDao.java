package com.cy.res.sys.dao;

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
	
}

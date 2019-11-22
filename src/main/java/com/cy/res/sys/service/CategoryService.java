package com.cy.res.sys.service;

import java.util.List;

import com.cy.res.sys.entity.CategoryEntity;

/**
 * 商品分类的业务层接口
 * @author Administrator
 *
 */
public interface CategoryService {

	/**
	 * 查询所有商品分类信息
	 * @return
	 */
	public List<CategoryEntity> findAllCategory();
}

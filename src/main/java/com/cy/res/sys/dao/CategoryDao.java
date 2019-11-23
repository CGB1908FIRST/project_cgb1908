package com.cy.res.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cy.res.sys.entity.CategoryEntity;
/**
 * 商品分类的数据层接口
 * @author xukeqing
 *
 */
@Mapper
public interface CategoryDao {

	/**
	 * 查询所有商品分类信息
	 * @return
	 */
	@Select("select * from category")
	public List<CategoryEntity> findAllCategory();
}

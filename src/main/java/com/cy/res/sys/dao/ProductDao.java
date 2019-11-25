package com.cy.res.sys.dao;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.res.sys.entity.ProductEntity;

/**
 * product数据层接口
 * @author xukeqing
 *
 */
@Mapper
public interface ProductDao {
	
	Integer[] findMemberIdByAreaId(Integer areaId);
	/**
	 * 根据条件查询product
	 * @param areaValue
	 * @param categoryValue
	 * @return
	 */
	ProductEntity[] findAllProduct(
			@Param("memberIds") Integer[] memberIds,
			@Param("categoryId") Integer categoryValue
			);
	/**
	 * 
	 * product通过id删除商品
	 * @author liuhaibo
	 */
	@Delete("delete from product where product_id=#{id}")
	  int deleteObject(Integer id);
	/**
	 * 添加商品信息
	 */
	int insertProduct(ProductEntity entity); 
	
}

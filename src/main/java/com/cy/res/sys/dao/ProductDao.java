package com.cy.res.sys.dao;


import java.util.List;

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
	
	/**
	 * 邹
	 * 查询总记录数
	 */
	int findRowCount(Integer memberId);
	/**
	 * 邹
	 * 查询分页信息
	 */
	List<ProductEntity> findPageObject(@Param("pageSize")Integer pageSize,
									   @Param("startIndex")Integer startIndex,
									   @Param("memberId") Integer memberId);
	
	/**
	 * 邹
	 * 更新数据
	 */
	int updateProduct(ProductEntity entity);
}
